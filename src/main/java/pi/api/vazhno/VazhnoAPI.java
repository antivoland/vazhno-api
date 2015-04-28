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

    public VazhnoAPIResponse.Info user(String token) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("authorization")
                .procedure("information")
                .token(token)
                .build();
        return request.send(VazhnoAPIResponse.Info.class);
    }

    public VazhnoAPIResponse.Policies policies(String token) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("policy")
                .procedure("list.policies")
                .token(token)
                .build();
        return request.send(VazhnoAPIResponse.Policies.class);
    }

    public VazhnoAPIResponse.Cars cars(String token) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("dictionary")
                .procedure("cars")
                .token(token)
                .build();
        return request.send(VazhnoAPIResponse.Cars.class);
    }

    public VazhnoAPIResponse.KaskoRisks kaskoRisks(String token) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("dictionary")
                .procedure("risks.kasko.full")
                .token(token)
                .build();
        return request.send(VazhnoAPIResponse.KaskoRisks.class);
    }

    public VazhnoAPIResponse.CalculateKaskoFull calculateKaskoFull(String token, VazhnoAPIRequestForm.CalculateKaskoFull calculateKaskoFull) throws VazhnoAPIException {
        VazhnoAPIRequest request = new VazhnoAPIRequest.Builder()
                .method("calculation")
                .procedure("kasko.full")
                .token(token)
                .data(calculateKaskoFull)
                .build();
        return request.send(VazhnoAPIResponse.CalculateKaskoFull.class);
    }
}
