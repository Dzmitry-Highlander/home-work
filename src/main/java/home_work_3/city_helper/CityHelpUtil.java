package home_work_3.city_helper;

import home_work_3.city_helper.enums.Params;

import java.util.*;

public class CityHelpUtil {
    public static List<String> getCities(List<String> list, Params params) {
        List<String> result = new ArrayList<>();

        Runnable runnable = () -> {
            if (!list.isEmpty()) {
                if (params == Params.UNIQUE) {
                    Set<String> set = new HashSet<>(list);

                    result.addAll(set);
                }

                if (params == Params.NAME_LONGER_THAN_6) {
                    for (String city : list) {
                        if (city.length() > 6) {
                            result.add(city);
                        }
                    }
                }
            }
        };

        runnable.run();

        return result;
    }

    public static List<String> getCities(List<String> list, char startsFromChar) {
        List<String> result = new ArrayList<>();

        Runnable runnable = () -> {
            if (!list.isEmpty()) {
                for (String city : list) {
                    if (city.toLowerCase().charAt(0) == startsFromChar ||
                            city.toUpperCase().charAt(0) == startsFromChar) {
                        result.add(city);
                    }
                }
            }
        };

        runnable.run();

        return result;
    }

    public static void count(List<String> list, String cityToCount) {
        Runnable runnable = () -> {
            int counter = 0;

            for (String city : list) {
                if (Objects.equals(city, cityToCount)) {
                    counter++;
                }
            }

            System.out.println(cityToCount + " appears in the list " + counter + " times");
        };

        runnable.run();
    }
}
