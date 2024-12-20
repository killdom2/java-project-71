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

        Map<String, Object> map1 = JsonIntoMap.convert(file1);
        Map<String, Object> map2 = JsonIntoMap.convert(file2);

        FindDifference findDifference = new FindDifference();
        return findDifference.compare(map1, map2);
    }

    static String readFile(String filePath) {
        String content = null;
        try {
            Path path = Paths.get(filePath);
            content = Files.readString(path);
        } catch (IOException e) {
            System.out.println("File not found: " + filePath);
        }
        return content;
    }
}
