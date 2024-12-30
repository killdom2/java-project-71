package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class Plain {
    public static String format(Map<String, Object> map1, Map<String, Object> map2, List<Map<String, Status>> list) {

        StringBuilder sb = new StringBuilder();
        for (Map<String, Status> map : list) {
            for (Map.Entry<String, Status> entry : map.entrySet()) {
                String key = entry.getKey();
                Status status = entry.getValue();
                switch (status) {
                    case UPDATED -> sb.append("Property '").append(key).append("' was updated. From ")
                            .append(map1.get(key)).append(" to ").append(map2.get(key))
                            .append(System.lineSeparator());
                    case REMOVED -> sb.append("Property '").append(key).append("' was removed")
                            .append(System.lineSeparator());
                    case ADDED -> sb.append("Property '").append(key).append("' was added with value: ")
                            .append(map2.get(key)).append(System.lineSeparator());
                    case SAME -> sb.append("");
                    default -> throw new RuntimeException("Unhandled status: " + status);
                }
            }
        }
        return sb.toString();
    }
}
