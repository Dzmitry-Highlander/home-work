package home_work_2.file_util.utils;

import java.io.*;

public class FileUtil {
    public void copyContentInUpperReg(String source, String destination) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                result.append(symbol.toUpperCase());
            }

            System.out.println(result);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
