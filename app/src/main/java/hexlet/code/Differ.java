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
            System.out.println("Need a files to compare");
        }

        Map<String, Object> map1 = Map.of();
        Map<String, Object> map2 = Map.of();

        if (filepath1.endsWith("json")) {
            map1 = Parse.jsonString(file1);
            map2 = Parse.jsonString(file2);
        } else  if (filepath1.endsWith("yaml") || filepath1.endsWith("yml")) {
            map1 = Parse.yamlString(file1);
            map2 = Parse.yamlString(file2);
        }

        Difference difference = new Difference();
        return difference.compare(map1, map2);
    }

    static String readFile(String filePath) throws IOException {

        Path path = Paths.get(filePath);
        return Files.readString(path);
    }
}
