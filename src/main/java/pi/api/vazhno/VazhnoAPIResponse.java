package pi.api.vazhno;

public class VazhnoAPIResponse {
    /*
    {
        "date":"10.02.2013 14:06:41",
        "token":"8hhf03i1vh2dvgmb3ha28is1t4",
        "generation":0.001,
        "error":false
    }
     */
    public static class Token {
        public String date;
        public String token;
        public String generation;
        public boolean error;
    }

    /*
    {
        "user": {
            "id": "1",
            "phone": "79151234567",
            "name": "Ivanov Ivan",
            "role": "administrator"
        },
        "date": "10.02.2014 14:12:55",
        "token": "8hhf03i1vh2dvgmb3ha28is1t4",
        "generation": 0.018,
        "error": false
    }
     */
    public static class Authorize {
        public static class User {
            public String id;
            public String phone;
            public String name;
            public String role;
        }

        public User user;
        public String date;
        public String token;
        public String generation;
        public boolean error;
    }
}
