package home_work_1.backup_utility.jobs;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Queue;

public class CopyJob implements Runnable {
    private final Path destinationDir;
    private final Queue<File> queue;

    public CopyJob(String destinationDir, Queue<File> queue) {
        this.destinationDir = Paths.get(destinationDir);
        this.queue = queue;
    }

    @Override
    public void run() {
        if (!destinationDir.toFile().exists() && destinationDir.toFile().isDirectory()) {
            destinationDir.toFile().mkdirs();
        }

        while (queue.peek() != null) {
            File file = new File(queue.poll().toPath().toUri());

            try {
                Files.copy(file.toPath(), destinationDir.resolve(file.getName()), StandardCopyOption.REPLACE_EXISTING);
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
