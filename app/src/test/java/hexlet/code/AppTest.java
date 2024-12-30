package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static org.junit.jupiter.api.Assertions.*;

public class AppTest {
    String filepath0;
    String filepath1;
    String filepath2;
    String filepath3;
    String filepath4;
    String format;

    @BeforeEach
    void setUp() {
        filepath0 = "src/main/resources/file1.json";
        filepath1 = "src/main/resources/nestedFile1.json";
        filepath2 = "src/main/resources/nestedFile2.json";
        filepath3 = "src/main/resources/nestedFile1.yaml";
        filepath4 = "src/main/resources/nestedFile2.yml";
        format = "";
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
            actual = Differ.generate(filepath1, filepath2, format);
            expected = readString(Path.of("src/test/resources/nestedExpected.txt"));
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
            actual = Differ.generate(filepath3, filepath4, format);
            expected = readString(Path.of("src/test/resources/nestedExpected.txt"));
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
    /*@Test
    void testChankedMap() throws IOException {
        setUp();
        var map = Parser.convertJson(readString(Path.of(filepath1)));
        var actual = ChankedMap.breakDownTheMap(map);
        String expected = readString(Path.of("src/test/resources/mapIntoList.txt"));
        assertEquals(expected, actual.toString());
    }*/
}
