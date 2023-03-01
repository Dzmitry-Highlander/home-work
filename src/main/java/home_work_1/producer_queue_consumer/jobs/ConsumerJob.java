package home_work_1.producer_queue_consumer.jobs;

import home_work_1.producer_queue_consumer.utils.FileUtil;

import java.util.Queue;
import java.util.concurrent.TimeUnit;

public class ConsumerJob implements Runnable {
    private final Queue<Integer> queue;

    public ConsumerJob(Queue<Integer> queue) {
        this.queue = queue;
    }


    @Override
    public void run() {
        FileUtil fileUtil = new FileUtil("dir/log.txt");

        while (queue.peek() != null) {
            int time = queue.poll();

            sleep(time);
            fileUtil.write("I slept " + time + " second(s)");
        }

        fileUtil.write("...");
        sleep(1);
    }

    private void sleep(int sec) {
        try {
            TimeUnit.SECONDS.sleep(sec);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
