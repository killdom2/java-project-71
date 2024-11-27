package hexlet.code;

import picocli.CommandLine;
import picocli.CommandLine.Command;

public class App {
    public static void main(String[] args) {
        new CommandLine(new MyHelp()).execute(args);
    }
}

@Command(name = "gendiff",
        mixinStandardHelpOptions = true,
        description = "Compares two configuration files and shows a difference.")

class MyHelp implements Runnable {
    public void run() {
    }
}
