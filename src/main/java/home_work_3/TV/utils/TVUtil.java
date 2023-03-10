package home_work_3.TV.utils;

import home_work_3.TV.dao.TV;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class TVUtil {
    public static List<TV> getTVByDiagonal(List<TV> list, double diagonal) {
        return list.stream()
                .filter(n -> n.getDiagonal() == diagonal)
                .collect(Collectors.toList());
    }

    public static List<TV> getTVByBrand(List<TV> list, String brand) {
        return list.stream()
                .filter(n -> Objects.equals(n.getBrand(), brand))
                .collect(Collectors.toList());
    }

    public static List<TV> getTVNotOlderThanYear(List<TV> list, int year) {
        return list.stream()
                .filter(n -> n.getModelYear() >= year)
                .collect(Collectors.toList());
    }

    public static List<TV> getTVByPriceRange(List<TV> list, double minPrice, double maxPrice) {
        return list.stream()
                .filter(n -> (n.getPrice() >= minPrice && n.getPrice() <= maxPrice))
                .collect(Collectors.toList());
    }

    public static List<TV> getTVByPrice(List<TV> list, boolean priceAscending) {
        List<TV> result;
        if (priceAscending) {
            result = list.stream()
                    .sorted(Comparator.comparing(TV::getPrice))
                    .collect(Collectors.toList());
        } else {
            result = list.stream()
                    .sorted(Comparator.comparing(TV::getPrice).reversed())
                    .collect(Collectors.toList());

        }
        return result;
    }

    public static List<TV> getTVByDiagonal(List<TV> list, boolean diagonalAscending) {
        List<TV> result;
        if (diagonalAscending) {
            result = list.stream()
                    .sorted(Comparator.comparing(TV::getDiagonal))
                    .collect(Collectors.toList());
        } else {
            result = list.stream()
                    .sorted(Comparator.comparing(TV::getDiagonal).reversed())
                    .collect(Collectors.toList());
        }
        return result;
    }
}
