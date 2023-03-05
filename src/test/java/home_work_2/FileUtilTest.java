package home_work_2;

import home_work_2.file_util.utils.FileUtil;
import org.junit.jupiter.api.*;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileUtilTest {
    private FileUtil fileUtil;

    @BeforeAll
    static void setFile() {
        File file = new File("source.txt");

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))){
            writer.write("Hi! Nice to meet you! My name is John Smith. I am 19 and a student in college. I go to " +
                    "college in New York. My favorite courses are Geometry, French, and History. English is my " +
                    "hardest course. My professors are very friendly and smart. It’s my second year in college now. " +
                    "I love it!");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @BeforeEach
    void init() {
        fileUtil = new FileUtil();
    }

    @DisplayName("Task 1, Переписывает содержимое одного файла в другой файл, в ВЕРХНЕМ РЕГИСТРЕ")
    @Test
    public void copyContentInUpperRegTest() {
        fileUtil.copyContentInUpperReg("source.txt", "result.txt");

        String result = read("result.txt").toString();
        String expected = "HI! NICE TO MEET YOU! MY NAME IS JOHN SMITH. I AM 19 AND A STUDENT IN COLLEGE. I GO TO " +
                "COLLEGE IN NEW YORK. MY FAVORITE COURSES ARE GEOMETRY, FRENCH, AND HISTORY. ENGLISH IS MY HARDEST " +
                "COURSE. MY PROFESSORS ARE VERY FRIENDLY AND SMART. IT’S MY SECOND YEAR IN COLLEGE NOW. I LOVE IT!";

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 2, Возвращает список строк для файла")
    @Test
    public void listOfStringsTest() {
        List<String> result = fileUtil.listOfStrings("source.txt");
        List<String> expected = new ArrayList<>(Collections.singleton("Hi! Nice to meet you! My name is John Smith. " +
                "I am 19 and a student in college. I go to college in New York. My favorite courses are Geometry, " +
                "French, and History. English is my hardest course. My professors are very friendly and smart. It’s " +
                "my second year in college now. I love it!"));

        Assertions.assertEquals(expected, result);
    }

    @DisplayName("Task 3, Возвращает список слов начинающихся с гласной буквы")
    @Test
    public void listOfVowelWordsTest() {
        List<String> result = fileUtil.listOfVowelWords("source.txt");
        List<String> expected = new ArrayList<>(List.of("you", "is", "I", "am", "and", "a", "in", "I",
                "in", "York", "are", "and", "English", "is", "are", "and", "It", "year", "in", "I", "it"));

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
