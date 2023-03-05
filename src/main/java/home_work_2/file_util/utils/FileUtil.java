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
        StringBuilder builder = read(source);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(destination))) {
            writer.write(builder.toString().toUpperCase());
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
        String[] strings = read(source).toString().split("\n");

        return new ArrayList<>(List.of(strings));
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
        String[] tmpSubStrings = read(source).toString().split("\\W+");

        for (String word : tmpSubStrings) {
            if (word.toLowerCase().substring(0, 1).matches("[aeiouy]")) {
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
        String[] strings = read(source).toString().split("\\W+");

        for (int i = 1; i < strings.length; i++) {
            if (strings[i].toLowerCase().charAt(0)
                    == strings[i - 1].toLowerCase().charAt(strings[i - 1].length() - 1)) {
                stringList.add(strings[i]);
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
    public List<String> longestSequence(String source) {
        List<String> stringList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] strings = line.split("\\W");
                int[] integers = new int[strings.length];

                for (int i = 0; i < strings.length; i++) {
                    integers[i] = Integer.parseInt(strings[i]);
                }

                StringBuilder stringBuf = new StringBuilder();
                String stringFinal = "";
                boolean newSeq = true;

                for (int i = 1; i < integers.length; i++) {
                    if (integers[i] <= integers[i - 1]) {
                        newSeq = true;
                    } else if (integers[i] > integers[i - 1] && newSeq && integers[i] - integers[i -1] == 1) {
                        stringBuf.append(integers[i - 1]).append(" ").append(integers[i]).append(" ");
                        newSeq = false;
                    } else if (!newSeq && integers[i] > integers[i - 1] && integers[i] - integers[i - 1] == 1) {
                        stringBuf.append(integers[i]);

                        if (stringBuf.toString().length() > stringFinal.length()) {
                            stringFinal = stringBuf.toString();
                        }

                        stringBuf = new StringBuilder();
                    }
                }

                stringList.add(stringFinal);
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
        String[] strings = read(source).toString().toLowerCase().split("");

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

        return map;
    }

    /**
     * Возвращает частоту повторяемости всех слов в тексте в порядке возрастания частоты повторяемости
     *
     * @param source путь к исходному файлу
     * @return TreeMap с повторяемостью каждой буквы в тексте
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public Map<String, Integer> frequencyWords(String source) {
        Map<String, Integer> map = new HashMap<>();
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        String[] strings = read(source).toString().toLowerCase().split("\\W+");


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

        map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEach(entry -> sortedMap.put(entry.getKey(), entry.getValue()));

        return sortedMap;
    }

    /**
     * Сортирует содержимое файла по возрастанию и сохраняющий результат в файл ${origin_filepath}_
     *
     * @param source путь к исходному файлу
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public void fileSorting(String source) {
        StringBuilder builder = new StringBuilder();
        String[] strings = read(source).toString().split("\\W");
        int[] integers = new int[strings.length];

        for (int i = 0; i < strings.length; i++) {
            integers[i] = Integer.parseInt(strings[i]);
        }

        Arrays.sort(integers);

        for (int integer : integers) {
            builder.append(integer).append(" ");
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source + "_"))) {
                writer.write(builder.toString().trim());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Возвращает успеваемость студентов
     *
     * @param source путь к исходному файлу
     * @return Map со списком фамилий и средним баллом
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public Map<String, Double> studentsAvg(String source) {
        Map<String, Double> map = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;

            while ((line = reader.readLine()) != null) {
                String[] strings = line.split("\\W+");
                double avgMark = 0.0;

                for (int i = 1; i < strings.length; i++) {
                    avgMark += Integer.parseInt(strings[i]);
                }

                avgMark = avgMark / (strings.length - 1);

                map.put(strings[0], Math.round(avgMark * 100.0) / 100.0);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return map;
    }

    /**
     * Заменяет все модификаторы доступа X в объявлении атрибутов и методов класса на Y и сохраняющий результат в
     * файл ${origin_filepath}_
     *
     * @param source путь к исходному файлу
     * @param existingModifier путь к исходному файлу
     * @param newModifier путь к исходному файлу
     * @throws RuntimeException, если происходит ошибка Ввода/Вывода
     */
    public void javaCode(String source, String existingModifier, String newModifier) {
        String[] strings = read(source).toString().split("\n");

        for (int i = 0; i < strings.length; i++) {
            strings[i] = strings[i].replaceAll(existingModifier, newModifier);
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(source + "_"))) {
            for (String string : strings) {
                writer.write(string + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private StringBuilder read(String source) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line).append("\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder;
    }
}
