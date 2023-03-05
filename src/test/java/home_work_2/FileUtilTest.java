package home_work_2;

import home_work_2.file_util.utils.FileUtil;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.*;

public class FileUtilTest {
    private static FileUtil fileUtil;

    @BeforeAll
    static void setFile() {
        fileUtil = new FileUtil();
    }

    @DisplayName("Task 1, Test, Переписывает содержимое одного файла в другой файл, в ВЕРХНЕМ РЕГИСТРЕ")
    @Test
    public void copyContentInUpperRegTest() {
        fileUtil.copyContentInUpperReg(
                "src/test/java/resources/source.txt",
                "src/test/java/resources/result.txt"
        );

        String result = read("src/test/java/resources/result.txt").toString();
        String expected = "HI! NICE TO MEET YOU! MY NAME IS JOHN SMITH. I AM 19 AND A STUDENT IN COLLEGE. I GO TO " +
                "COLLEGE IN NEW YORK. MY FAVORITE COURSES ARE GEOMETRY, FRENCH, AND HISTORY. ENGLISH IS MY HARDEST " +
                "COURSE. MY PROFESSORS ARE VERY FRIENDLY AND SMART. IT’S MY SECOND YEAR IN COLLEGE NOW. I LOVE IT!";

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 2, Test, Возвращает список строк для файла")
    @Test
    public void listOfStringsTest() {
        List<String> result = fileUtil.listOfStrings("src/test/java/resources/source.txt");
        List<String> expected = new ArrayList<>(Collections.singleton("Hi! Nice to meet you! My name is John Smith. " +
                "I am 19 and a student in college. I go to college in New York. My favorite courses are Geometry, " +
                "French, and History. English is my hardest course. My professors are very friendly and smart. It’s " +
                "my second year in college now. I love it!"));

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 3, Test, Возвращает список слов начинающихся с гласной буквы")
    @Test
    public void listOfVowelWordsTest() {
        List<String> result = fileUtil.listOfVowelWords("src/test/java/resources/source.txt");
        List<String> expected = new ArrayList<>(List.of("you", "is", "I", "am", "and", "a", "in", "I",
                "in", "York", "are", "and", "English", "is", "are", "and", "It", "year", "in", "I", "it"));

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 4, Test, Возвращает список слов, для которых последняя буква совпадает с первой буквой " +
            "следующего за ним слова")
    @Test
    public void listOfCoincidencesTest() {
        List<String> result = fileUtil.listOfCoincidences("src/test/java/resources/source.txt");
        List<String> expected = new ArrayList<>(List.of("New"));

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 5, Test, Возвращает список слов, для которых последняя буква совпадает с первой буквой " +
            "следующего за ним слова")
    @Test
    public void longestSequenceTest() {
        List<String> result = fileUtil.listOfCoincidences("src/test/java/resources/source.txt");
        List<String> expected = new ArrayList<>(List.of("New"));

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 6, Test, Возвращает список слов, для которых последняя буква совпадает с первой буквой " +
            "следующего за ним слова")
    @Test
    public void frequencyLettersTest() {
        Map<Character, Integer> result = fileUtil.frequencyLetters("src/test/java/resources/source.txt");
        Map<Character, Integer> part1 = new HashMap<>(Map.of(
                'a', 12, 'c', 8, 'd', 7, 'e', 28, 'f', 4, 'g', 6,
                'h', 7, 'i', 17, 'j', 1, 'k', 1
        ));
        Map<Character, Integer> part2 = new HashMap<>(Map.of(
                'l', 9, 'm', 11, 'n', 16, 'o', 19, 'p', 1, 'r', 16,
                's', 16, 't', 13, 'u', 4, 'v', 3
        ));
        Map<Character, Integer> part3 = new HashMap<>(Map.of(
                'w', 2, 'y', 12
        ));
        Map<Character, Integer> expected = new HashMap<>();
        expected.putAll(part1);
        expected.putAll(part2);
        expected.putAll(part3);

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 7, Test 1, Возвращает частоту повторяемости всех слов в тексте в порядке возрастания частоты " +
            "повторяемости")
    @Test
    public void frequencyWordsTest1() {
        Assertions.assertTrue(fileUtil.frequencyWords("src/test/java/resources/source.txt").containsKey("my"));
        Assertions.assertTrue(fileUtil.frequencyWords("src/test/java/resources/source.txt").containsKey("i"));
        Assertions.assertTrue(fileUtil.frequencyWords("src/test/java/resources/source.txt").containsKey("and"));
    }

    @DisplayName("Task 7, Test 2, Возвращает частоту повторяемости всех слов в тексте в порядке возрастания частоты " +
            "повторяемости")
    @Test
    public void frequencyWordsTest2() {
        String result = Arrays.toString(
                fileUtil.frequencyWords("src/test/java/resources/source.txt").values().toArray(
                ));
        String expected = "[1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, " +
                "1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 5]";

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 8, Test, Сортирует содержимое файла по возрастанию и сохраняет результат " +
            "в файл ${origin_filepath}_")
    @Test
    public void fileSortingTest() {
        fileUtil.fileSorting("src/test/java/resources/list.txt");

        String result = read("src/test/java/resources/list.txt" + "_").toString();
        String expected = "1 1 2 2 3 23 67 68 69";

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 9, Test, возвращает успеваемость студентов")
    @Test
    public void studentsAvgTest() {
        Map<String, Double> result = fileUtil.studentsAvg("src/test/java/resources/students.txt");
        Map<String, Double> expected = new HashMap<>(Map.of("Krasiuk", 8.5, "Rakovets", 8.0,
                "Putin", 1.67));

        Assertions.assertEquals(expected, result);
    }

    private StringBuilder read(String source) {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(source))) {
            String line;

            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return builder;
    }
}
