package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {
    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        String file1 = "";
        String file2 = "";

        try {
            file1 = readFile(filepath1);
            file2 = readFile(filepath2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Files not found");
        }

        Map<String, Object> map1 = Map.of();
        Map<String, Object> map2 = Map.of();

        if (filepath1.endsWith("json")) {
            map1 = Parser.convertJson(file1);
            map2 = Parser.convertJson(file2);
        } else if (filepath1.endsWith("yaml") || filepath1.endsWith("yml")) {
            map1 = Parser.convertYaml(file1);
            map2 = Parser.convertYaml(file2);
        }

        var list = Difference.compare(map1, map2);
        return Formatter.choose(map1, map2, list, format);
    }

    static String readFile(String filePath) throws IOException {

        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
}
