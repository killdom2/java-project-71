package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChankedMap {
    static List<Map<Fields, Object>> breakDownTheMap(Map<Fields, Object> originalMap) {

        List<Map<Fields, Object>> maps = new ArrayList<>();
        Map<Fields, Object> chankedMap = new HashMap<>(Map.of());

        for (Map.Entry<Fields, Object> entry : originalMap.entrySet()) {
            chankedMap.put(entry.getKey(), entry.getValue());
            maps.add(chankedMap);
            chankedMap = new HashMap<>(Map.of());
        }

        return maps;
    }
}
