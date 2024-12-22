package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class AppTest {
    String filepath1;
    String filepath2;
    String format;

    @BeforeEach
    void setUp() {
        filepath1 = "src/main/resources/file1.json";
        filepath2 = "src/main/resources/file2.json";
        format = "";
    }

    @Test
    void testDifferGenerate1() {
        assertThrows(IOException.class,
                () -> Differ.generate("Path missing", "Path missing", format));
    }

    @Test
    void testDifferGenerate2() {
        setUp();
        String expected;
        String actual;
        try {
            actual = Differ.generate(filepath1, filepath2, format);
            expected = readString(Path.of("src/main/resources/expected"));
            assertEquals(expected, actual);
        } catch (Exception ignored) {
        }
    }

    @Test
    void testDifferReadFile1() {
        setUp();
        try {
            String expected = readString(Path.of(filepath1));
            String actual = Differ.readFile(filepath1);
            assertEquals(expected, actual);
        } catch (IOException e) {
        }
    }

    @Test
    void testDifferReadFile2() {
        try {
            String fileNotFound = Differ.readFile("File missing");
            assertNull(fileNotFound);
        } catch (IOException e) {
            System.out.print("");
        }
    }
}
