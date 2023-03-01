package home_work_1.producer_queue_consumer.exceptions;

public class UserInputException extends Exception {
    public UserInputException() {
        super("User input Exception");
    }

    public UserInputException(String message) {
        super(message);
    }
}

