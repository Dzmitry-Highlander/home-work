package home_work_2.file_util.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/** Класс утилита
 @author Dzmitry Krasiuk
 */
public class FileUtil {
    /** Переписывает содержимое одного файла в другой файл, в ВЕРХНЕМ РЕГИСТРЕ
     * @param source путь к исходному файлу
     * @param destination путь к результирующему файлу
     */
    public void copyContentInUpperReg(String source, String destination) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                result.append(symbol.toUpperCase()).append("\n");
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

    /** Возвращает список строк для исходного файла
     * @param source путь к исходному файлу
     * @return список строк файла
     */
    public List<String> listOfStrings(String source) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                stringList.add(symbol);
            }

            System.out.println(stringList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringList;
    }
}
