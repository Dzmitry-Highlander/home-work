package home_work_3.TV;

import home_work_3.TV.dao.TV;
import home_work_3.TV.utils.TVUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TVUtilTest {
    static List<TV> tvList;

    @BeforeAll
    static void init() {
        tvList = new ArrayList<>();
        tvList.add(new TV("LG", "55NANO766QA", 2022, 55, 1985.00));
        tvList.add(new TV("LG", "50UQ80006LB", 2022, 50, 1794.97));
        tvList.add(new TV("LG", "43UP77006LB", 2021, 43, 1763.47));
        tvList.add(new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00));
        tvList.add(new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00));
        tvList.add(new TV("Samsung", "UE43T5300AUXRU", 2020, 43, 1727.90));
    }

    @DisplayName("TVUtil.getTVByDiagonal() Test 1, return TV's list with given diagonal")
    @Test
    void getTVByDiagonalTest1() {
        List<TV> result = TVUtil.getTVByDiagonal(tvList, 43);
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00),
                new TV("Samsung", "UE43T5300AUXRU", 2020, 43, 1727.90),
                new TV("LG", "43UP77006LB", 2021, 43, 1763.47)
        ));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVByDiagonal() Test 2, return TV's list with given diagonal")
    @Test
    void getTVByDiagonalTest2() {
        List<TV> result = TVUtil.getTVByDiagonal(tvList, 43);
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00),
                new TV("Samsung", "UE43T5300AUXRU", 2020, 43, 1727.90),
                new TV("LG", "43UP77006LB", 2021, 43, 1763.47),
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00)
        ));

        Assertions.assertFalse(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVByBrand() Test 3, return TV's list with given brand")
    @Test
    void getTVByBrandTest3() {
        List<TV> result = TVUtil.getTVByBrand(tvList, "Samsung");
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00),
                new TV("Samsung", "UE43T5300AUXRU", 2020, 43, 1727.90),
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00)
        ));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVByBrand() Test 4, return TV's list with given brand")
    @Test
    void getTVByBrandTest4() {
        List<TV> result = TVUtil.getTVByBrand(tvList, "Samsung");
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00),
                new TV("Samsung", "UE43T5300AUXRU", 2020, 43, 1727.90),
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00),
                new TV("LG", "43UP77006LB", 2021, 43, 1763.47)
        ));

        Assertions.assertFalse(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVOlderThanYear() Test 5, return TV's list which not older than given year")
    @Test
    void getTVNotOlderThanYearTest5() {
        List<TV> result = TVUtil.getTVNotOlderThanYear(tvList, 2022);
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00),
                new TV("LG", "55NANO766QA", 2022, 55, 1985.00),
                new TV("LG", "50UQ80006LB", 2022, 50, 1794.97)
        ));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVOlderThanYear() Test 6, return TV's list which not older than given year")
    @Test
    void getTVNotOlderThanYearTest6() {
        List<TV> result = TVUtil.getTVNotOlderThanYear(tvList, 2022);
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00),
                new TV("LG", "55NANO766QA", 2022, 55, 1985.00),
                new TV("LG", "50UQ80006LB", 2022, 50, 1794.97),
                new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00)
        ));

        Assertions.assertFalse(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVByPriceRange() Test 7, return TV's list with given price range")
    @Test
    void getTVByPriceRangeTest7() {
        List<TV> result = TVUtil.getTVByPriceRange(tvList, 5000, 7000);
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00)
        ));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVByPriceRange() Test 8, return TV's list with given price range")
    @Test
    void getTVByPriceRangeTest8() {
        List<TV> result = TVUtil.getTVByPriceRange(tvList, 5000, 7000);
        List<TV> expected = new ArrayList<>(List.of(
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00),
                new TV("LG", "55NANO766QA", 2022, 55, 1985.00),
                new TV("LG", "50UQ80006LB", 2022, 50, 1794.97),
                new TV("Samsung", "QE43QN90AAU", 2021, 43, 3510.00)
        ));

        Assertions.assertFalse(result.containsAll(expected));
    }

    @DisplayName("TVUtil.getTVByPrice() Test 9, return TV's list with TV's sorted by price")
    @Test
    void getTVByPriceTest9() {
        List<TV> result = TVUtil.getTVByPrice(tvList, true);

        Assertions.assertEquals(
                new TV("Samsung", "UE43T5300AUXRU", 2020, 43, 1727.90),
                result.get(0));
    }

    @DisplayName("TVUtil.getTVByPrice() Test 10, return TV's list with TV's sorted by price")
    @Test
    void getTVByPriceTest10() {
        List<TV> result = TVUtil.getTVByPrice(tvList, false);

        Assertions.assertEquals(
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00),
                result.get(0));
    }

    @DisplayName("TVUtil.getTVByDiagonal() Test 11, return TV's list with TV's sorted by diagonal")
    @Test
    void getTVByDiagonalTest11() {
        List<TV> result = TVUtil.getTVByDiagonal(tvList, true);

        Assertions.assertEquals(
                new TV("LG", "43UP77006LB", 2021, 43, 1763.47),
                result.get(0));
    }

    @DisplayName("TVUtil.getTVByDiagonal() Test 12, return TV's list with TV's sorted by diagonal")
    @Test
    void getTVByDiagonalTest12() {
        List<TV> result = TVUtil.getTVByDiagonal(tvList, false);

        Assertions.assertEquals(
                new TV("Samsung", "QE65QN90BAUXCE", 2022, 65, 6200.00),
                result.get(0));
    }
}
