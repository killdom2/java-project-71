package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;

public class Differ {

    public static String generate(String filepath1, String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }

    public static String generate(String filepath1, String filepath2, String format) throws Exception {

        String file1 = readFile(filepath1);
        String file2 = readFile(filepath2);

        String[] arr = filepath1.split("\\.");
        String extension = arr[arr.length - 1];

        Map<String, Object> map1 = Parser.parse(file1, extension);
        Map<String, Object> map2 = Parser.parse(file2, extension);

        var differences = Comparator.compare(map1, map2);

        return Formatter.choose(differences, format);
    }

    static String readFile(String filePath) throws IOException {

        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }
}
