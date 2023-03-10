package home_work_3.math_statistic;

import home_work_3.math_statistic.enums.Params;
import home_work_3.math_statistic.utils.MathStatUtil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MathStatUtilTest {
    private final int[] numbers = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 0};

    @DisplayName("MathStatUtil.generate() Test ")
    @Test
    void generateTest() {
        int[] result = MathStatUtil.generate();

        Assertions.assertTrue(result.length > 0);
    }

    @DisplayName("MathStatUtil.generate() Test 1, returns String Zero count")
    @Test
    void countTest1() {
        Assertions.assertEquals("Zero count 2", MathStatUtil.count(numbers, Params.ZERO_EQUALS));
    }

    @DisplayName("MathStatUtil.generate() Test 2, returns String Even count")
    @Test
    void countTest2() {
        Assertions.assertEquals("Even count 5", MathStatUtil.count(numbers, Params.EVEN));
    }

    @DisplayName("MathStatUtil.generate() Test 3, returns String Odd count")
    @Test
    void countTest3() {
        Assertions.assertEquals("Odd count 5", MathStatUtil.count(numbers, Params.ODD));
    }

    @DisplayName("MathStatUtil.generate() Test 4, returns String Equals count")
    @Test
    void countTest4() {
        Assertions.assertEquals("Equals 3 count: 1", MathStatUtil.count(numbers, 3));
    }
}
