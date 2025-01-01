package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String choose(List<Map<Fields, Object>> differences, String format) {

        return switch (format) {
            case "stylish" -> Stylish.format(differences);
            case "plain" -> Plain.format(differences);
            default -> "Format not supported";
        };
    }
}
