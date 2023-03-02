package home_work_2.file_util.utils;

import java.io.*;

/** Класс утилита FileUtil
 @author Dzmitry Krasiuk
 */
public class FileUtil {
    /** Метод, который принимает пути к двум файлам. Метод переписывает содержимое одного файла в другой файл, но
     * только в ВЕРХНЕМ РЕГИСТРЕ
     * @param source путь к исходному файлу
     * @param destination путь к результирующему файлу
     */
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

    public void listOfStrings(String source) {

    }
}
