package hexlet.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    String filepath1;
    String filepath2;
    String expectedStylish;
    String expectedJson;
    String expectedPlain;
    String format;

    @BeforeEach
    void setUp() {
        filepath1 = "file1";
        filepath2 = "file2";
        expectedStylish = "expectedStylish.txt";
        expectedJson = "expectedJson.json";
        expectedPlain = "expectedPlain.txt";
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testDefaultFormat(String fileFormat) throws Exception {
        setUp();
        var file1 = getAbsolutePath(filepath1 + fileFormat);
        var file2 = getAbsolutePath(filepath2 + fileFormat);
        var expected = Files.readString(Paths.get(getAbsolutePath(expectedStylish)));
        String actual = Differ.generate(format, file1, file2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testStylish(String fileFormat) throws Exception {
        setUp();
        format = "stylish";
        var file1 = getAbsolutePath(filepath1 + fileFormat);
        var file2 = getAbsolutePath(filepath2 + fileFormat);
        var expected = Files.readString(Paths.get(getAbsolutePath(expectedStylish)));
        String actual = Differ.generate(format, file1, file2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testPlain(String fileFormat) throws Exception {
        setUp();
        format = "plain";
        var file1 = getAbsolutePath(filepath1 + fileFormat);
        var file2 = getAbsolutePath(filepath2 + fileFormat);
        var expected = Files.readString(Paths.get(getAbsolutePath(expectedPlain)));
        String actual = Differ.generate(format, file1, file2);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testJson(String fileFormat) throws Exception {
        setUp();
        format = "json";
        var file1 = getAbsolutePath(filepath1 + fileFormat);
        var file2 = getAbsolutePath(filepath2 + fileFormat);
        var expected = Files.readString(Paths.get(getAbsolutePath(expectedJson)));
        String actual = Differ.generate(format, file1, file2);
        assertEquals(expected, actual);
    }

    private String getAbsolutePath(String fileName) {
        return Paths.get("src", "test", "resources", fileName)
                .toAbsolutePath().normalize().toString();
    }
}
