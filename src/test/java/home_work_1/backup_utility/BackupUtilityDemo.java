package home_work_1.backup_utility;

import home_work_1.backup_utility.config.ThreadConfig;

public class BackupUtilityDemo {
    public static void main(String[] args) {
        String source = "dir";
        String destination = "dir/backup";
        ThreadConfig threadConfig = new ThreadConfig(source, destination, 3);

        threadConfig.start();
    }
}
