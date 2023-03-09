package home_work_3.city_helper.utils;

import home_work_3.city_helper.enums.Params;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;

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

    public static int count(List<String> list, String cityToCount) {
        AtomicInteger counter = new AtomicInteger();

        Runnable runnable = () -> {
            for (String city : list) {
                if (Objects.equals(city, cityToCount)) {
                    counter.getAndIncrement();
                }
            }
        };

        runnable.run();

        return counter.get();
    }
}
