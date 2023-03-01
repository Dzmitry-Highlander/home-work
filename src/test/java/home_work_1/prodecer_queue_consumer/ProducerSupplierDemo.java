package home_work_1.prodecer_queue_consumer;

import home_work_1.producer_queue_consumer.config.ThreadConfig;

public class ProducerSupplierDemo {
    public static void main(String[] args) {
        ThreadConfig threadConfig = new ThreadConfig(3);

        threadConfig.start();
    }
}