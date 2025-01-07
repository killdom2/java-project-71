package hexlet.code;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    private static final String FILEPATH1 = getAbsolutePath("file1");
    private static final String FILEPATH2 = getAbsolutePath("file2");
    private static final String EXPECTED_STYLISH;

    static {
        try {
            EXPECTED_STYLISH = Files.readString(Paths
                    .get(getAbsolutePath("expectedStylish.txt")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testDefaultFormat(String fileFormat) throws Exception {
        String actual = Differ.generate(FILEPATH1 + fileFormat, FILEPATH2 + fileFormat);
        assertEquals(EXPECTED_STYLISH, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testStylish(String fileFormat) throws Exception {
        String actual = Differ
                .generate(FILEPATH1 + fileFormat, FILEPATH2 + fileFormat, "stylish");
        assertEquals(EXPECTED_STYLISH, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testPlain(String fileFormat) throws Exception {
        var expected = Files.readString(Paths
                .get(getAbsolutePath("expectedPlain.txt")));
        String actual = Differ
                .generate(FILEPATH1 + fileFormat, FILEPATH2 + fileFormat, "plain");
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @ValueSource(strings = {".json", ".yaml"})
    void testJson(String fileFormat) throws Exception {
        var expected = Files.readString(Paths
                .get(getAbsolutePath("expectedJson.json")));
        String actual = Differ
                .generate(FILEPATH1 + fileFormat, FILEPATH2 + fileFormat, "json");
        assertEquals(expected, actual);
    }

    private static String getAbsolutePath(String fileName) {
        return Paths.get("src", "test", "resources", "fixtures", fileName)
                .toAbsolutePath().normalize().toString();
    }
}
