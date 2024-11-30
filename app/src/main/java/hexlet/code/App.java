package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;

import java.io.File;
import java.util.concurrent.Callable;

public class App {
    public static void main(String[] args) {
        new CommandLine(new MyHelp()).execute(args);
    }
}

//https://picocli.info/#_usage_help

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "Differ 1.0")


class MyHelp implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        return 0;
    }
    @Option(names = {"-f", "--format"},
            description = "output format [default: stylish]",
            paramLabel = "format")
    File file;
    @Parameters(index = "0",
            description = "path to first file",
            paramLabel = "filepath1")
    String filepath1;
    @Parameters(index = "0",
            description = "path to second file",
            paramLabel = "filepath2")
    String filepath2;
}
