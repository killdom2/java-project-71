package hexlet.code;

import hexlet.code.formatters.Plain;
import hexlet.code.formatters.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String choose(Map<String, Object> map1, Map<String, Object> map2,
                                List<Map<String, Status>> list, String format) {

        return switch (format) {
            case "stylish" -> Stylish.format(map1, map2, list);
            case "plain" -> Plain.format(map1, map2, list);
            default -> "Format not supported";
        };
    }
}
