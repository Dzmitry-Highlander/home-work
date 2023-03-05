package home_work_2;

import home_work_2.file_util.utils.FileUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtilTest {
    private static File file;
    private FileUtil fileUtil;

    @BeforeAll
    static void setFile() {
        file = new File("source.txt");

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

    @Test
    public void copyContentInUpperRegTest() {
        fileUtil.copyContentInUpperReg("source.txt", "result.txt");
    }
}
