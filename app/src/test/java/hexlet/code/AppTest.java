package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class AppTest {
    String filepath1;
    String filepath2;
    String filepath3;
    String filepath4;
    String format;

    @BeforeEach
    void setUp() {
        filepath1 = "src/main/resources/jsonFile1.json";
        filepath2 = "src/main/resources/jsonFile2.json";
        filepath3 = "src/main/resources/yamlFile1.yaml";
        filepath4 = "src/main/resources/yamlFile2.yml";
        format = "stylish";
    }

    @Test
    void testDifferGenerate() {
        assertThrows(IOException.class,
                () -> Differ.generate("Path missing", "Path missing", format));
    }

    @Test
    void testDifferGenerateJson() {
        setUp();
        String expected;
        String actual;
        try {
            actual = Differ.generate(format, filepath1, filepath2);
            expected = readString(Path.of("src/test/resources/expectedStylish.txt"));
            assertEquals(expected, actual);
        } catch (Exception ignored) {
            System.out.println("File not found");
        }
    }

    @Test
    void testDifferGenerateYaml() {
        setUp();
        String expected;
        String actual;
        try {
            actual = Differ.generate(format, filepath3, filepath4);
            expected = readString(Path.of("src/test/resources/expectedStylish.txt"));
            assertEquals(expected, actual);
        } catch (Exception ignored) {
            System.out.println("File not found");
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
            System.out.println("File not found");
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
    @Test
    void testApp() {
        App app = new App();
        assertThrows(NullPointerException.class, app::call);
    }
    @Test
    void testJson() throws Exception {
        setUp();
        format = "json";
        var expected = Files.readString(Path.of("src/test/resources/expectedJson.json"));
        var actual = Differ.generate(format, filepath1, filepath2);
        assertEquals(expected, actual);
    }
}
