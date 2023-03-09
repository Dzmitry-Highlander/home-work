package home_work_3.city_helper;

import home_work_3.city_helper.enums.Params;
import home_work_3.city_helper.utils.CityHelpUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class CityHelpUtilTest {
    List<String> citiesList = new ArrayList<>(List.of(
            new String[]{"Homiel", "Mozyr", "Minsk", "Mogilev", "Brest", "Hrodno", "Mozyr", "Vitebsk", "Minsk"}));

    @DisplayName("CityHelpUtil.getCities() Test 1, with param UNIQUE, return list of unique cities")
    @Test
    void getCitiesTest1() {
        List<String> result = CityHelpUtil.getCities(citiesList, Params.UNIQUE);
        List<String> expected = new ArrayList<>(List.of(
                new String[]{"Homiel", "Mozyr", "Minsk", "Mogilev", "Brest", "Hrodno", "Vitebsk"}));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("CityHelpUtil.getCities() Test 2, with param UNIQUE, return list of unique cities")
    @Test
    void getCitiesTest2() {
        List<String> result = CityHelpUtil.getCities(citiesList, Params.UNIQUE);
        List<String> expected = new ArrayList<>(List.of(
                new String[]{"Homiel", "Mozyr", "Minsk", "Mogilev", "Brest", "Hrodno", "Mozyr", "Vitebsk", "Minsk"}));

        Assertions.assertNotEquals(result.size(), expected.size());
    }

    @DisplayName("CityHelpUtil.getCities() Test 3, with param NAME_LONGER_THAN_6, return list of cities which name " +
            "longer than 6 characters")
    @Test
    void getCitiesTest3() {
        List<String> result = CityHelpUtil.getCities(citiesList, Params.NAME_LONGER_THAN_6);
        List<String> expected = new ArrayList<>(List.of(
                new String[]{"Mogilev", "Vitebsk"}));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("CityHelpUtil.getCities() Test 4, with param NAME_LONGER_THAN_6, return list of cities which name " +
            "longer than 6 characters")
    @Test
    void getCitiesTest4() {
        List<String> result = CityHelpUtil.getCities(citiesList, Params.NAME_LONGER_THAN_6);
        List<String> expected = new ArrayList<>(List.of(
                new String[]{"Mogilev", "Mozyr"}));

        Assertions.assertFalse(result.containsAll(expected));
    }

    @DisplayName("CityHelpUtil.getCities() Test 5, return list which starts with specified character")
    @Test
    void getCitiesTest5() {
        List<String> result = CityHelpUtil.getCities(citiesList, 'M');
        List<String> expected = new ArrayList<>(List.of(
                new String[]{"Mozyr", "Minsk", "Mogilev", "Mozyr", "Minsk"}));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("CityHelpUtil.getCities() Test 6, return list which starts with specified character")
    @Test
    void getCitiesTest6() {
        List<String> result = CityHelpUtil.getCities(citiesList, 'm');
        List<String> expected = new ArrayList<>(List.of(
                new String[]{"Mozyr", "Minsk", "Mogilev", "Mozyr", "Minsk"}));

        Assertions.assertTrue(result.containsAll(expected));
    }

    @DisplayName("CityHelpUtil.count() Test 7, return how many times specified city appears in list")
    @Test
    void getCitiesTest7() {
        Assertions.assertEquals(2, CityHelpUtil.count(citiesList, "Mozyr"));
    }

    @DisplayName("CityHelpUtil.count() Test 8, return how many times specified city appears in list")
    @Test
    void getCitiesTest8() {
        Assertions.assertNotEquals(2, CityHelpUtil.count(citiesList, "Homiel"));
    }
}
