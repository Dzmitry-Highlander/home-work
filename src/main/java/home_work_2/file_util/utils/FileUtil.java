package home_work_2.file_util.utils;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/** Класс утилита для работы с текстовыми файлами
 @author Dzmitry Krasiuk
 */
public class FileUtil {
    /** Переписывает содержимое одного файла в другой файл, в ВЕРХНЕМ РЕГИСТРЕ
     * @param source путь к исходному файлу
     * @param destination путь к результирующему файлу
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public void copyContentInUpperReg(String source, String destination) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                result.append(symbol.toUpperCase()).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write(result.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Возвращает список строк для файла
     * @param source путь к исходному файлу
     * @return список строк
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public List<String> listOfStrings(String source) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                stringList.add(symbol);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringList;
    }

    /** Возвращает список слов начинающихся с гласной буквы
     * @param source путь к исходному файлу
     * @return список слов
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public List<String> listOfVowelWords(String source) {
        List<String> stringList = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                tmp.append(symbol).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] tmpSubStrings = tmp.toString().split("\\s");

        for (String word : tmpSubStrings) {
            if (word.charAt(0) == 'a' || word.charAt(0) == 'e' || word.charAt(0) == 'i'
                    || word.charAt(0) == 'o' || word.charAt(0) == 'u' || word.charAt(0) == 'y' || word.charAt(0) == 'A'
                    || word.charAt(0) == 'E' || word.charAt(0) == 'I' || word.charAt(0) == 'O' || word.charAt(0) == 'U'
                    || word.charAt(0) == 'Y' || word.charAt(0) == 'а' || word.charAt(0) == 'у' || word.charAt(0) == 'о'
                    || word.charAt(0) == 'ы' || word.charAt(0) == 'э' || word.charAt(0) == 'я' || word.charAt(0) == 'ю'
                    || word.charAt(0) == 'ё' || word.charAt(0) == 'и' || word.charAt(0) == 'е' || word.charAt(0) == 'А'
                    || word.charAt(0) == 'У' || word.charAt(0) == 'О' || word.charAt(0) == 'Ы' || word.charAt(0) == 'Э'
                    || word.charAt(0) == 'Я' || word.charAt(0) == 'Ю' || word.charAt(0) == 'Ё' || word.charAt(0) == 'И'
                    || word.charAt(0) == 'Е') {
                stringList.add(word);
            }
        }

        return stringList;
    }

    /** Возвращает список слов, для которых последняя буква совпадает с первой буквой следующего за ним слова
     * @param source путь к исходному файлу
     * @return список слов
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public List<String> listOfCoincidences(String source) {
        List<String> stringList = new ArrayList<>();
        StringBuilder tmp = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                tmp.append(symbol).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String[] tmpSubStrings = tmp.toString().split("\\s");

        for (int i = 0; i < tmpSubStrings.length - 1; i++) {
            if (tmpSubStrings[i].toLowerCase().charAt(tmpSubStrings[i].length() - 1) ==
                    tmpSubStrings[i + 1].toLowerCase().charAt(0)) {
                stringList.add(tmpSubStrings[i]);
            }
        }

        System.out.println(stringList);
        return stringList;
    }
}
