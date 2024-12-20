package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.nio.file.Path;

import static java.nio.file.Files.readString;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    void test() throws Exception {
        setUp();
        String file1 = readString(Path.of(filepath1));
        String file2 = readString(Path.of(filepath2));
        assertNotEquals(file1, file2);
    }
    @Test
    void test2() {
        assertThrows(IllegalArgumentException.class,
                () -> Differ.generate("Path missing", "Path missing", format));
    }
    @Test
    void test3() {
        String readFile = Differ.readFile(filepath1);
        assertNotEquals("", readFile);
    }
    @Test
    void test4() {
        String fileNotFound = Differ.readFile("File is absent");
        assertNull(fileNotFound);
    }
}
