package home_work_1.producer_queue_consumer.config;

import home_work_1.producer_queue_consumer.jobs.ConsumerJob;
import home_work_1.producer_queue_consumer.suppliers.ProducerSupplier;

import java.util.Queue;
import java.util.concurrent.*;

public class ThreadConfig {
    private Integer nThreads;
    private final Queue<Integer> queue;

    public ThreadConfig(Integer nThreads) {
        this.nThreads = nThreads;
        this.queue = new PriorityBlockingQueue<>();
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(
                nThreads);

        Future<?> future = executor.submit(new ProducerSupplier(queue));
        try {
            future.get();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println(e.getMessage());
        }

        for (; nThreads > 0; nThreads--) {
            executor.execute(new ConsumerJob(queue));
        }

        executor.shutdown();
    }
}
