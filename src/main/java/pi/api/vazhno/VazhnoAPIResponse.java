package pi.api.vazhno;

import java.util.List;
import java.util.Map;

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
            public String activated;
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
            public String activated;
        }

        public User user;
        public String date;
        public String token;
        public Number generation;
    }

    public static class Info extends VazhnoAPIResponse {
        public static class User {
            public String id;
            public String email;
            public String name;
            public String lastname;
            public String activated;
        }

        public User user;
        public String date;
        public String token;
        public Number generation;
    }

    public static class Policies extends VazhnoAPIResponse {
        public static class Policy {
            public String id;
        }

        public List<Policy> policies;
        public String date;
        public String token;
        public Number generation;
    }

    public static class Cars extends VazhnoAPIResponse {
        public static class Car {
            public String model;
            public String type;
        }

        public Map<String, List<Car>> cars;
    }

    public static class KaskoRisks extends VazhnoAPIResponse {
        public static class Risk {
            public String name;
            public String caption;
            public String hint;
            public Object price; // todo: neither int neither array
            public Number max_price;
            public Number default_price;
            public List<String> options;
            public Map<String, List<String>> sub_option;
            public List<Wheels> options_wheels;
            public String text_info;
        }

        public static class Wheels {
            public String checkbox;
            public Integer max_price;
            public Integer default_price;
        }

        public List<Risk> risks;
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
