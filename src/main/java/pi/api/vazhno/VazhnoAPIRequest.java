package pi.api.vazhno;

import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class VazhnoAPIRequest {
    private static final String API_URL = "https://api.vazhno.me";
    private static final Logger log = Logger.getLogger(VazhnoAPIRequest.class);
    private static final ObjectMapper mapper = new ObjectMapper();

    {
        mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    private final Map<String, String> data;

    private VazhnoAPIRequest(Map<String, String> data) {
        this.data = data;
    }

    public <T extends VazhnoAPIResponse> T send(Class<T> clazz) throws VazhnoAPIException {
        try {
            StringBuilder query = new StringBuilder();
            Iterator<Map.Entry<String, String>> iterator = data.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<String, String> entry = iterator.next();
                query.append(entry.getKey()).append("=").append(URLEncoder.encode(entry.getValue(), "UTF-8"));
                if (iterator.hasNext()) {
                    query.append("&");
                }
            }

            URL url = new URL(API_URL + "?" + query.toString());
            URLConnection connection = url.openConnection();
            InputStream stream = connection.getInputStream();
            JsonNode node = mapper.readTree(stream);
            log.debug(url.toString() + " -> " + node.toString());

            T resp = mapper.treeToValue(node, clazz);
            if (resp.error) {
                VazhnoAPIResponse.Error error = mapper.treeToValue(node, VazhnoAPIResponse.Error.class);
                throw new VazhnoAPIException(error);
            }
            return resp;
        } catch (IOException e) {
            throw new VazhnoAPIException(e);
        }
    }

    public static class Builder {
        private final Map<String, String> data = new HashMap<>();

        public Builder method(String method) {
            data.put("method", method);
            return this;
        }

        public Builder procedure(String procedure) {
            data.put("procedure", procedure);
            return this;
        }

        public Builder data(String key, String value) {
            data.put("data[" + key + "]", value);
            return this;
        }

        public Builder token(String token) {
            data.put("token", token);
            return this;
        }

        public VazhnoAPIRequest build() {
            return new VazhnoAPIRequest(data);
        }
    }
}
