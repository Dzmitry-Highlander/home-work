package home_work_3;

public class MultiplicationTable {
    public static void tableOut() {
        Runnable runnable = () -> {
            StringBuilder builder = new StringBuilder();
            Integer[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

            for (Integer integer : numbers) {
                for (Integer number : numbers) {
                    builder.append(integer).append(" x ").append(number).append(" = ")
                            .append(integer * number).append("\n");
                }
                builder.append("\n");
            }

            System.out.println(builder);
        };

        runnable.run();
    }
}
