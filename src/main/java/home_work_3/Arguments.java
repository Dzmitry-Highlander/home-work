package home_work_3;

import org.w3c.dom.css.Counter;

import java.util.HashMap;
import java.util.Map;

public class Arguments {
    public static Map<String, String> getArguments(String[] strings) {
        Map<String, String> map = new HashMap<>();

        Runnable runnable = () -> {
            StringBuilder key = new StringBuilder();
            StringBuilder value = new StringBuilder();

            for (String string : strings) {
                if (string.charAt(0) == '-') {
                    key.append(string);
                } else {
                    value.append(string);
                    map.put(key.toString(), value.toString());
                    key = new StringBuilder();
                    value = new StringBuilder();
                }
            }
        };

        runnable.run();

        return map;
    }

    public static String[] convert(Map<String, String> map) {
        String[] strings = new String[map.size()];

        Runnable runnable = () -> {
            StringBuilder builder = new StringBuilder();
            int counter = 0;

            for (Map.Entry<String, String> item : map.entrySet()) {
                builder.append(item.getKey()).append(" ").append(item.getValue());

                strings[counter] = builder.toString();
                counter++;
                builder = new StringBuilder();
            }
        };

        runnable.run();

        return strings;
    }
}
