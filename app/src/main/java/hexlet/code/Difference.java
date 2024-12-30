package hexlet.code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;
import java.util.Comparator;

import static hexlet.code.Status.UPDATED;
import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.REMOVED;
import static hexlet.code.Status.SAME;


public class Difference {
    public static List<Map<String, Status>> compare(Map<String, Object> map1, Map<String, Object> map2) {
        TreeSet<String> keys = new TreeSet<>();
        keys.addAll(map1.keySet());
        keys.addAll(map2.keySet());

        Map<String, Status> result = new HashMap<>();

        for (String key : keys) {
            if (map1.containsKey(key) && map2.containsKey(key)) {
                boolean isEqual = false;
                try {
                    isEqual = map1.get(key).equals(map2.get(key));
                } catch (Exception ignored) {
                }
                if (isEqual) {
                    result.put(key, SAME);
                } else {
                    result.put(key, UPDATED);
                }
            } else if (map1.containsKey(key) && !map2.containsKey(key)) {
                result.put(key, REMOVED);
            } else if (!map1.containsKey(key) && map2.containsKey(key)) {
                result.put(key, ADDED);
            }
        }

        List<Map<String, Status>> list = ChankedMap.breakDownTheMap(result);
        list.sort(Comparator.comparing(Object::toString));

        return list;
    }
}
