package hexlet.code.formatters;

import hexlet.code.Status;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(Map<String, Object> map1, Map<String, Object> map2, List<Map<String, Status>> list) {

        StringBuilder sb = new StringBuilder();
        sb.append("{").append(System.lineSeparator());

        for (Map<String, Status> map : list) {
            for (Map.Entry<String, Status> entry : map.entrySet()) {
                String key = entry.getKey();
                Status status = entry.getValue();
                switch (status) {
                    case SAME -> sb.append("    ").append(key).append(": ")
                            .append(map1.get(key)).append(System.lineSeparator());
                    case UPDATED -> sb.append("  - ").append(key).append(": ")
                            .append(map1.get(key)).append(System.lineSeparator())
                            .append("  + ").append(key).append(": ")
                            .append(map2.get(key)).append(System.lineSeparator());
                    case REMOVED -> sb.append("  - ").append(key).append(": ")
                            .append(map1.get(key)).append(System.lineSeparator());
                    case ADDED -> sb.append("  + ").append(key).append(": ")
                            .append(map2.get(key)).append(System.lineSeparator());
                    default -> throw new RuntimeException("Unhandled status " + status);
                }
            }
        }
        return sb.append("}").toString();
    }
}
