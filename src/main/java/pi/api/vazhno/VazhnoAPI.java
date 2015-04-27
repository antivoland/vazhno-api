package pi.api.vazhno;

import java.text.SimpleDateFormat;
import java.util.Date;

public class VazhnoAPI {
    private SimpleDateFormat BIRTHDAY = new SimpleDateFormat("dd.MM.yyyy");

    public VazhnoAPIResponse.Token token() throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("token")
                .procedure("get")
                .build();
        return request.send(VazhnoAPIResponse.Token.class);
    }

    public VazhnoAPIResponse.Authorize authorize(String token, String email, String password) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("authorization")
                .procedure("authorize")
                .token(token)
                .data("email", email)
                .data("password", password)
                .build();
        return request.send(VazhnoAPIResponse.Authorize.class);
    }

    public VazhnoAPIResponse.Register register(String name, String lastname, String middlename, Date birthdate, String email, String password) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("authorization")
                .procedure("registration")
                .token(token().token) // todo: reuse token
                .data("name", name)
                .data("lastname", lastname)
                .data("middlename", middlename)
                .data("birthdate", BIRTHDAY.format(birthdate))
                .data("email", email)
                .data("password", password)
                .build();
        return request.send(VazhnoAPIResponse.Register.class);
    }

    // todo: do something with data
    public VazhnoAPIResponse.Info user(String token) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("authorization")
                .procedure("registration")
                .token(token)
                .build();
        return request.send(VazhnoAPIResponse.Info.class);
    }
}
