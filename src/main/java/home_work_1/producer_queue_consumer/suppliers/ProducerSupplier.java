package home_work_1.producer_queue_consumer.suppliers;

import home_work_1.producer_queue_consumer.exceptions.UserInputException;

import java.util.Queue;
import java.util.Scanner;

public class ProducerSupplier implements Runnable {
    private final Queue<Integer> queue;

    public ProducerSupplier(Queue<Integer> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter an positive Integer: ");

        while (scanner.hasNext() && !Thread.currentThread().isInterrupted()) {
            if (scanner.hasNextInt()) {
                int time = scanner.nextInt();

                if (time >= 0) {
                    queue.add(time);
                    System.out.println("Time " + time + " has been added to Queue!");
                } else if (time == -1) {
                    System.out.println("Input has been ended!");
                    break;
                } else {
                    throwException();
                    scanner.next();
                }
            } else {
                throwException();
                scanner.next();
            }
        }

        Thread.currentThread().interrupt();
        scanner.close();
    }

    private void throwException() {
        try {
            throw new UserInputException("Enter an positive Integer!");
        } catch (UserInputException e) {
            System.out.println(e.getMessage());
        }
    }
}
