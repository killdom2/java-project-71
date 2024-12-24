package hexlet.code;

import java.util.Map;
import java.util.TreeSet;

public class Difference {
    String compare(Map<String, Object> map1, Map<String, Object> map2) {

        StringBuilder difference = new StringBuilder();

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        difference.append("{").append(System.lineSeparator());
        boolean isIquals;

        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                try {
                    isIquals = map1.get(key).equals(map2.get(key));
                } catch (NullPointerException e) {
                    isIquals = false;
                }
                if (isIquals) {
                    difference.append("    ").append(key).append(": ")
                            .append(map1.get(key)).append(System.lineSeparator());
                } else {
                    difference.append("  - ").append(key).append(": ")
                            .append(map1.get(key)).append(System.lineSeparator());
                    difference.append("  + ").append(key).append(": ")
                            .append(map2.get(key)).append(System.lineSeparator());
                }
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                difference.append("  - ").append(key).append(": ")
                        .append(map1.get(key)).append(System.lineSeparator());
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                difference.append("  + ").append(key).append(": ")
                        .append(map2.get(key)).append(System.lineSeparator());
            }
        }

        difference.append("}");

        return difference.toString();
    }
}
