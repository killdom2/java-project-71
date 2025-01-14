package hexlet.code;

import hexlet.code.common.Field;
import hexlet.code.common.Status;

import java.util.Map;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashMap;

public class Comparator {
    public static List<Map<Field, Object>> compare(
            Map<String, Object> map1, Map<String, Object> map2) {

        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        List<Map<Field, Object>> diffList = new ArrayList<>();

        for (String key : keys) {
            Map<Field, Object> differences = new HashMap<>();
            differences.put(Field.FIELD, key);
            if (!map1.containsKey(key)) {
                differences.put(Field.STATUS, Status.ADDED);
                differences.put(Field.NEW_VALUE, map2.get(key));
            } else if (!map2.containsKey(key)) {
                differences.put(Field.STATUS, Status.REMOVED);
                differences.put(Field.OLD_VALUE, map1.get(key));
            } else if (Objects.equals(map1.get(key), map2.get(key))) {
                differences.put(Field.STATUS, Status.SAME);
                differences.put(Field.OLD_VALUE, map1.get(key));
            } else {
                differences.put(Field.STATUS, Status.UPDATED);
                differences.put(Field.OLD_VALUE, map1.get(key));
                differences.put(Field.NEW_VALUE, map2.get(key));
            }
            diffList.add(differences);
        }
        return diffList;
    }
}
