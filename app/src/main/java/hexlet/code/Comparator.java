package hexlet.code;

import java.util.Map;
import java.util.List;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;

import static hexlet.code.Fields.FIELD;
import static hexlet.code.Fields.STATUS;
import static hexlet.code.Fields.OLD_VALUE;
import static hexlet.code.Fields.NEW_VALUE;
import static hexlet.code.Status.UPDATED;
import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.REMOVED;
import static hexlet.code.Status.SAME;


public class Comparator {
    public static List<Map<Fields, Object>> compare(Map<String, Object> map1, Map<String, Object> map2) {
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<Map<Fields, Object>> diffList = new ArrayList<>();

        for (String key : keys) {
            Map<Fields, Object> differences = new HashMap<>();
            differences.put(FIELD, key);
            if (map1.containsKey(key) && map2.containsKey(key)) {
                boolean isEqual = false;
                try {
                    isEqual = map1.get(key).equals(map2.get(key));
                } catch (Exception ignored) {
                }
                if (isEqual) {
                    differences.put(STATUS, SAME);
                    differences.put(OLD_VALUE, map1.get(key));
                } else {
                    differences.put(STATUS, UPDATED);
                    differences.put(OLD_VALUE, map1.get(key));
                    differences.put(NEW_VALUE, map2.get(key));
                }
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                differences.put(STATUS, REMOVED);
                differences.put(OLD_VALUE, map1.get(key));
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                differences.put(STATUS, ADDED);
                differences.put(NEW_VALUE, map2.get(key));
            }

            diffList.add(differences);
        }

        return diffList;
    }
}
