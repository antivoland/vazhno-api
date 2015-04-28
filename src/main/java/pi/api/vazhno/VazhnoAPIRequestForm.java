package pi.api.vazhno;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class VazhnoAPIRequestForm {
    public static class CalculateKaskoFull extends VazhnoAPIRequestForm {
        public static class Car {
            public String manufacturer;
            public String model;
            public Number seats;
            public Number year;
            public String color;
        }

        public static class Driver {
            public Number minimalAge;
            public Number minimalExperience;
        }

        public Car car;
        public Driver driver;
        // todo: risks
        public Number cost;
        public String startInsurance;
        public Number Period;
        public String Purpose;
        public String Payment;
        public String PaymentType;
        public String limit;
        public String repair;
        public Number keys;
    }

    // todo: walk recursive, make plain
    public Map<String, String> serialize() {
        Map<String, String> serialized = new HashMap<>();
        for (Field f : getClass().getDeclaredFields()) {
            String value;
            try {
                value = f.get(this).toString();
            } catch (IllegalAccessException e) {
                throw new Error(e);
            }
            serialized.put("data[" + f.getName() + "]", value);
        }
        return serialized;
    }
}
