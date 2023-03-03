package home_work_2.file_util.utils;

import java.io.*;
import java.util.*;

/**
 * Класс утилита для работы с текстовыми файлами
 *
 * @author Dzmitry Krasiuk
 */
public class FileUtil {
    /**
     * Переписывает содержимое одного файла в другой файл, в ВЕРХНЕМ РЕГИСТРЕ
     *
     * @param source      путь к исходному файлу
     * @param destination путь к результирующему файлу
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public void copyContentInUpperReg(String source, String destination) {
        StringBuilder result = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                result.append(symbol).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write(result.toString().toUpperCase());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Возвращает список строк для файла
     *
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

    /**
     * Возвращает список слов начинающихся с гласной буквы
     *
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
                    || word.charAt(0) == 'Y') {
                stringList.add(word);
            }
        }

        return stringList;
    }

    /**
     * Возвращает список слов, для которых последняя буква совпадает с первой буквой следующего за ним слова
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
            if (tmpSubStrings[i].toLowerCase().charAt(tmpSubStrings[i].length() - 1)
                    == tmpSubStrings[i + 1].toLowerCase().charAt(0)) {
                stringList.add(tmpSubStrings[i]);
            }
        }

        return stringList;
    }

    /**
     * Возвращает список наибольшей комбинации цифр для каждой строки, которые идут в порядке возрастания
     *
     * @param source путь к исходному файлу
     * @return список цифр
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public List<String> maxCombination(String source) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;

            while ((symbol = reader.readLine()) != null) {
                ArrayList<Integer> arrayList = new ArrayList<>();
                String[] strings = symbol.split("\\W");

                for (String string : strings) {
                    if (string.charAt(0) >= '0' && string.charAt(0) <= '9') {
                        arrayList.add(Integer.valueOf(string));
                    }
                }

                String result = "";
                StringBuilder tmp = new StringBuilder();

                if (arrayList.size() > 0) {
                    boolean newSeq = true;

                    for (int i = 1; i < arrayList.size(); i++) {
                        if (arrayList.get(i) <= arrayList.get(i - 1)) {
                            newSeq = true;
                        } else if (arrayList.get(i) > arrayList.get(i - 1) && newSeq) {
                            tmp.append(arrayList.get(i - 1)).append(" ").append(arrayList.get(i));
                            newSeq = false;
                        } else if (arrayList.get(i) > arrayList.get(i - 1) && !newSeq) {
                            tmp.append(" ").append(arrayList.get(i));
                        }
                    }

                    System.out.println(tmp);
                }

                if (result.length() > 0)stringList.add(result);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return stringList;
    }

    /**
     * Возвращает частоту повторяемости всех букв в тексте, игнорируя регистр
     *
     * @param source путь к исходному файлу
     * @return HashMap с повторяемостью каждой буквы в тексте
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public Map<Character, Integer> frequencyLetters(String source) {
        Map<Character, Integer> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;
            StringBuilder builder = new StringBuilder();

            while ((symbol = reader.readLine()) != null) {
                builder.append(symbol).append("\n");
            }

            String[] strings = builder.toString().toLowerCase().split("");
            char letter = 'a';
            int counter = 0;

            while (letter <= 'z') {
                for (String ch : strings) {
                    if (letter == ch.charAt(0)) {
                        map.put(letter, ++counter);
                    }
                }

                letter++;
                counter = 0;
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    /**
     * Возвращает частоту повторяемости всех слов в тексте в порядке возрастания частоты повторяемости
     *
     * @param source путь к исходному файлу
     * @return HashMap с повторяемостью каждой буквы в тексте
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */

    public Map<String, Integer> frequencyWords(String source) {
        Map<String, Integer> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String symbol;
            StringBuilder builder = new StringBuilder();

            while ((symbol = reader.readLine()) != null) {
                builder.append(symbol).append("\n");
            }

            String[] strings = builder.toString().toLowerCase().split("\\W");
            String word = "";
            int counter = 0;

            do {
                for (String s : strings) {
                    word = s;
                    for (String string : strings) {
                        if (Objects.equals(string, word)) {
                            map.put(word, ++counter);
                        }
                    }

                    counter = 0;
                }
            } while (!Objects.equals(word, strings[strings.length - 1]));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }
}
