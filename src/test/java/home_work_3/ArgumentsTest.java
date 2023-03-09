package home_work_3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class ArgumentsTest {
    static String[] argumentsAndValues;

    @BeforeAll
    static void init() {
        argumentsAndValues = new String[]{"-i", "in.txt", "--limit", "40", "-d", "1", "-o", "out.txt"};
    }

    @DisplayName("Arguments.getArguments() Test 1")
    @Test
    void getArgumentsTest1() {
        Map<String, String> result = Arguments.getArguments(argumentsAndValues);

        Assertions.assertEquals("in.txt", result.get("-i"));
    }

    @DisplayName("Arguments.getArguments() Test 2")
    @Test
    void getArgumentsTest2() {
        Map<String, String> result = Arguments.getArguments(argumentsAndValues);

        Assertions.assertEquals("40", result.get("--limit"));
    }

    @DisplayName("Arguments.getArguments() Test 3")
    @Test
    void getArgumentsTest3() {
        Map<String, String> result = Arguments.getArguments(argumentsAndValues);

        Assertions.assertEquals("1", result.get("-d"));
    }

    @DisplayName("Arguments.getArguments() Test 4")
    @Test
    void getArgumentsTest4() {
        Map<String, String> result = Arguments.getArguments(argumentsAndValues);

        Assertions.assertEquals("out.txt", result.get("-o"));
    }
}
