package pi.api.vazhno;

public class VazhnoAPIResponse {
    public static class Token extends VazhnoAPIResponse {
        public String date;
        public String token;
        public Number generation;
    }

    public static class Authorize extends VazhnoAPIResponse {
        public static class User {
            public String id;
            public String email;
            public String name;
            public String lastname;
        }

        public User user;
        public String date;
        public String token;
        public Number generation;
    }

    public static class Register extends VazhnoAPIResponse {
        public static class User {
            public String email;
            public String name;
            public String lastname;
        }

        public User user;
        public String date;
        public String token;
        public Number generation;
    }

    public static class Error extends VazhnoAPIResponse {
        public String type;
        public Number code;
        public String message;
        public String date;
        public String token;
        public Number generation;
    }

    public boolean error;
}
