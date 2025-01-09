package hexlet.code;

import hexlet.code.common.Field;

import java.util.Map;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;

import static hexlet.code.common.Field.FIELD;
import static hexlet.code.common.Field.STATUS;
import static hexlet.code.common.Field.OLD_VALUE;
import static hexlet.code.common.Field.NEW_VALUE;
import static hexlet.code.common.Status.UPDATED;
import static hexlet.code.common.Status.ADDED;
import static hexlet.code.common.Status.REMOVED;
import static hexlet.code.common.Status.SAME;

public class Comparator {
    public static List<Map<Field, Object>> compare(
            Map<String, Object> map1, Map<String, Object> map2) {

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<Map<Field, Object>> diffList = new ArrayList<>();

        for (String key : keys) {
            Map<Field, Object> differences = new HashMap<>();
            differences.put(FIELD, key);
            if (!map1.containsKey(key)) {
                differences.put(STATUS, ADDED);
                differences.put(NEW_VALUE, map2.get(key));
            } else if (!map2.containsKey(key)) {
                differences.put(STATUS, REMOVED);
                differences.put(OLD_VALUE, map1.get(key));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                differences.put(STATUS, SAME);
                differences.put(OLD_VALUE, map1.get(key));
            } else {
                differences.put(STATUS, UPDATED);
                differences.put(OLD_VALUE, map1.get(key));
                differences.put(NEW_VALUE, map2.get(key));
            }
            diffList.add(differences);
        }
        return diffList;
    }
}
