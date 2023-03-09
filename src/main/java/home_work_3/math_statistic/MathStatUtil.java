package home_work_3.math_statistic;

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

    public static void count(int[] numbers, int someValue) {
        StringBuilder builder = new StringBuilder();

        Runnable runnable = () -> {
            int even = 0;
            int odd = 0;
            int zero = 0;
            int value = 0;

            for (int number : numbers) {
                if (number == someValue) {
                    value++;
                } else if (number == 0) {
                    zero++;
                } else if (number % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }

            builder.append("Четных: ").append(even).append("\n").append("Нечетных: ").append(odd).append("\n").
                    append("Равных нулю: ").append(zero).append("\n").append("Равных ").append(someValue).append(": ").
                    append(value);

            System.out.println(builder);
        };

        runnable.run();
    }
}
