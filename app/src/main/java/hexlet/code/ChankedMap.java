package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChankedMap {
    static List<Map<String, Status>> breakDownTheMap(Map<String, Status> originalMap) {

        List<Map<String, Status>> maps = new ArrayList<>();
        Map<String, Status> chankedMap = new HashMap<>(Map.of());

        for (Map.Entry<String, Status> entry : originalMap.entrySet()) {
            chankedMap.put(entry.getKey(), entry.getValue());
            maps.add(chankedMap);
            chankedMap = new HashMap<>(Map.of());
        }

        return maps;
    }
}
