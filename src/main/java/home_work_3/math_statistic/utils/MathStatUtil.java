package home_work_3.math_statistic.utils;

import home_work_3.math_statistic.enums.Params;

import java.util.concurrent.ThreadLocalRandom;

public class MathStatUtil {
    private static final ThreadLocalRandom rnd = ThreadLocalRandom.current();

    public static int[] generate() {
        int[] numbers = new int[rnd.nextInt(10,100)];

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = rnd.nextInt(0,100);
        }

        return numbers;
    }

    public static String count(int[] numbers, int someValue) {
        StringBuilder builder = new StringBuilder();

        Runnable runnable = () -> {
            int value = 0;

            for (int number : numbers) {
                if (number == someValue) {
                    value++;
                }
            }

            builder.append("Equals ").append(someValue).append(" count: ").append(value);
        };

        runnable.run();

        return builder.toString();
    }

    public static String count(int[] numbers, Params params) {
        StringBuilder builder = new StringBuilder();

        Runnable runnable = () -> {
            int even = 0;
            int odd = 0;
            int zero = 0;

            for (int number : numbers) {
                if (number == 0 && params == Params.ZERO_EQUALS) {
                    zero++;
                } else if (number != 0 && number % 2 == 0  && params == Params.EVEN) {
                    even++;
                } else if (number % 2 != 0 && params == Params.ODD) {
                    odd++;
                }
            }

            if (params == Params.ZERO_EQUALS) {
                builder.append("Zero count ").append(zero);
            } else if (params == Params.EVEN) {
                builder.append("Even count ").append(even);
            } else if (params == Params.ODD) {
                builder.append("Odd count ").append(odd);
            }
        };

        runnable.run();

        return builder.toString();
    }
}
