package hexlet.code;

import java.io.IOException;
import java.nio.file.Path;

import picocli.CommandLine;

import static java.nio.file.Files.readString;

public class App {
    public static void main(String[] args) throws IOException {
//        new CommandLine(new MyHelp()).execute(args);

        var file1 = readString(Path.of("src/main/resources/file1.json"));
        var file2 = readString(Path.of("src/main/resources/file2.json"));

        JsonIntoMap map1 = new JsonIntoMap();
        System.out.println(map1.convert(file1));
        JsonIntoMap map2 = new JsonIntoMap();
        System.out.println(map2.convert(file2));
    }
}
