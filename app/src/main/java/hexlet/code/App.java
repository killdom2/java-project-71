package hexlet.code;

import picocli.CommandLine;
import java.io.IOException;
import java.util.concurrent.Callable;

@CommandLine.Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.",
        version = "Differ 1.0")


public class App implements Callable<Integer>  {
    @CommandLine.Option(names = {"-f", "--format"},
            paramLabel = "format",
            description = "output format [default: stylish]")
    private String format;
    @CommandLine.Parameters(index = "0",
            paramLabel = "filepath1",
            description = "path to first file")
    private String filepath1;
    @CommandLine.Parameters(index = "1",
            paramLabel = "filepath2",
            description = "path to second file")
    private String filepath2;

    @Override
    public Integer call() throws Exception {
        return 0;
    }

    public static void main(String[] args) throws IOException {

        FileIntoString file = new FileIntoString();
        String file1 = "";
        String file2 = "";
        JsonIntoMap jsonIntoMap = new JsonIntoMap();
        JsonObject fMap1;
        JsonObject fMap2;

        try {
            file1 = file.read(args[0]);
            file2 = file.read(args[1]);
            fMap1 = jsonIntoMap.convert(file1);
            fMap2 = jsonIntoMap.convert(file2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Need a files to compare");
        }






        int exitCode = new CommandLine(new App()).execute(args);
        System.out.println(exitCode);
    }
}
