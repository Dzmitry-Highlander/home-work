package home_work_3;

import java.util.HashMap;
import java.util.Map;

public class Task1 {
    public Map<String, String> getArguments(String[] strings) {
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
}
