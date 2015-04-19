package pi.api.vazhno;

public class VazhnoAPI {
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
}
