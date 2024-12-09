package hexlet.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class FileIntoString {
    String read(String filePath) throws IOException {
        String content = null;
        try {
            Path path = Paths.get(filePath);
            content = Files.readString(path);
            System.out.println(content);
        } catch (IOException e) {
            System.out.println("File not found: " + filePath);
        }
        return content;
    }
}
