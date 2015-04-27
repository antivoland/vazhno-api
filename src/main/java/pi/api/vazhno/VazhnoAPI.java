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

    public VazhnoAPIResponse.Authorize authorize(String email, String password) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("authorization")
                .procedure("authorize")
                .token(token().token)
                .data("email", email)
                .data("password", password)
                .build();
        return request.send(VazhnoAPIResponse.Authorize.class);
    }

    public VazhnoAPIResponse.Register register(String name, String lastname, String middlename, Date birthdate, String email, String password) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("authorization")
                .procedure("registration")
                .token(token().token)
                .data("name", name)
                .data("lastname", lastname)
                .data("middlename", middlename)
                .data("birthdate", BIRTHDAY.format(birthdate))
                .data("email", email)
                .data("password", password)
                .build();
        return request.send(VazhnoAPIResponse.Register.class);
    }
}
