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

        String content1 = readFile(filepath1);
        String content2 = readFile(filepath2);

        String extension1 = getExtension(filepath1);
        String extension2 = getExtension(filepath2);

        Map<String, Object> map1 = Parser.parse(content1, extension1);
        Map<String, Object> map2 = Parser.parse(content2, extension2);

        var differences = Comparator.compare(map1, map2);

        return Formatter.format(differences, format);
    }

    static String readFile(String filePath) throws IOException {
        Path path = Paths.get(filePath).toAbsolutePath().normalize();
        return Files.readString(path);
    }

    static String getExtension(String filepath) {
        String[] arr = filepath.split("\\.");
        return arr[arr.length - 1];
    }
}
