package pi.api.vazhno;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VazhnoAPIResponse {
    /*
    {
       "date":"10.02.2013 14:06:41",
       "token":"8hhf03i1vh2dvgmb3ha28is1t4",
       "generation":0.001,
       "error":false
    }
     */
    public static class Token extends VazhnoAPIResponse {
        public String date;
        public String token;
        public Number generation;
    }

    /*
    {
       "user":{
          "id":"1",
          "phone":"79151234567",
          "name":"Ivanov Ivan",
          "role":"administrator"
       },
       "date":"10.02.2014 14:12:55",
       "token":"8hhf03i1vh2dvgmb3ha28is1t4",
       "generation":0.018,
       "error":false
    }
     */
    public static class Authorize extends VazhnoAPIResponse {
        public static class User {
            public String id;
            public String phone;
            public String name;
            public String role;
        }

        public User user;
        public String date;
        public String token;
        public Number generation;
    }

    /*
    {
       "error":true,
       "type":"authorize",
       "code":2,
       "message":"Пользователь не найден, не активирован или имя пользователя и пароль некорректны",
       "date":"20.04.2015 09:37:42",
       "token":"2e9g9l8qr8uh9of7fk5ltfot66",
       "generation":0.005,
       "stack":{
          "method":"authorization",
          "procedure":"authorize",
          "data":{
             "email":"antivoland@gmail.com",
             "password":"*"
          }
       }
    }
     */
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
