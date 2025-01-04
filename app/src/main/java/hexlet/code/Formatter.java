package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import hexlet.code.formatters.Json;
import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String choose(List<Map<Fields, Object>> differences, String format) throws JsonProcessingException {

        return switch (format) {
            case "stylish" -> Stylish.format(differences);
            case null -> Stylish.format(differences);
            case "plain" -> Plain.format(differences);
            case "json" -> Json.format(differences);
            default -> "Format not supported";
        };
    }
}
