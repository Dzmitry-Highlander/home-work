package home_work_3;

import java.util.stream.IntStream;

public class MultiplicationTable {
    public static void tableOutInOne() {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    IntStream.rangeClosed(1, 10)
                            .forEach(j -> System.out.printf("%s * %s = %s\n", i, j, i * j));
                    System.out.println();
                });
    }

    public static void tableOutInOneInFive() {
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    IntStream.rangeClosed(1, 5)
                            .forEach(j -> System.out.printf("%s * %s = %s\t", j, i, j * i));
                    System.out.println();
                });
        System.out.println();
        IntStream.rangeClosed(1, 10)
                .forEach(i -> {
                    IntStream.rangeClosed(6, 10)
                            .forEach(j -> System.out.printf("%s * %s = %s\t", j, i, j * i));
                    System.out.println();
                });
    }
}
