package home_work_1.backup_utility.config;

import home_work_1.backup_utility.jobs.CopyJob;
import home_work_1.backup_utility.suppliers.FilesSupplier;

import java.io.File;
import java.util.Queue;
import java.util.concurrent.*;

public class ThreadConfig {
    private final String source;
    private final String destination;
    private Integer nThreads;
    private final Queue<File> queue;


    public ThreadConfig(String source, String destination, Integer nThreads) {
        this.source = source;
        this.destination = destination;
        this.nThreads = nThreads;
        this.queue = new LinkedBlockingQueue<>();
    }

    public void start() {
        ExecutorService executor = Executors.newFixedThreadPool(
                nThreads);

        if (source != null) {
            Future<?> future = executor.submit(new FilesSupplier(source, queue));
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e.getMessage());
            }
        }

        for (; nThreads > 0; nThreads--) {
            if (destination != null) {
                executor.execute(new CopyJob(destination, queue));
            }
        }

        executor.shutdown();
    }
}
