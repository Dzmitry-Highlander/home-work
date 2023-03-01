package home_work_1.backup_utility.suppliers;

import java.io.File;
import java.util.Arrays;
import java.util.Queue;

public class FilesSupplier implements Runnable {
    private final File sourceDir;
    private final Queue<File> queue;

    public FilesSupplier(String sourceDir, Queue<File> queue) {
        this.sourceDir = new File(sourceDir);
        this.queue = queue;
    }

    @Override
    public void run() {
        if (sourceDir.isDirectory()) {
            System.out.println("Directory found: " + sourceDir.getName() + "\n");

            File[] files = sourceDir.listFiles();

            if (files != null) {
                queue.addAll(Arrays.asList(files));
            }

            System.out.println("List of files in " + sourceDir.getName() + ":");
            for (File file : queue) {
                System.out.println(file.getName());
            }
        }
    }
}
