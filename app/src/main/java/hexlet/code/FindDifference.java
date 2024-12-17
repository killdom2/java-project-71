package hexlet.code;

import java.util.Map;
import java.util.TreeSet;

public class FindDifference {
    String compare(Map<String, Object> map1, Map<String, Object> map2){

        StringBuilder difference = new StringBuilder();

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        difference.append("{\n");
        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                if (map1.get(key).equals(map2.get(key))) {
                    difference.append("  ").append(key).append(": ").append(map1.get(key)).append("\n");
                } else {
                    difference.append("- ").append(key).append(": ").append(map1.get(key)).append("\n");
                    difference.append("+ ").append(key).append(": ").append(map2.get(key)).append("\n");
                }
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                difference.append("- ").append(key).append(": ").append(map1.get(key)).append("\n");
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                difference.append("+ ").append(key).append(": ").append(map2.get(key)).append("\n");
            }
        }
        difference.append("}\n");

        return difference.toString();
    }
}
