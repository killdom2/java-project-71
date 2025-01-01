package hexlet.code.formatters;

import hexlet.code.Fields;

import java.util.List;
import java.util.Map;

import static hexlet.code.Fields.FIELD;
import static hexlet.code.Fields.STATUS;
import static hexlet.code.Fields.OLD_VALUE;
import static hexlet.code.Fields.NEW_VALUE;
import static hexlet.code.Status.ADDED;
import static hexlet.code.Status.SAME;
import static hexlet.code.Status.UPDATED;
import static hexlet.code.Status.REMOVED;

public class Stylish {
    public static String format(List<Map<Fields, Object>> differences) {

        StringBuilder sb = new StringBuilder();
        sb.append("{").append(System.lineSeparator());

        for (Map<Fields, Object> map : differences) {
            var status = map.get(STATUS);
            switch (status)  {
                case SAME -> sb.append("    ").append(map.get(FIELD)).append(": ")
                        .append(map.get(OLD_VALUE)).append(System.lineSeparator());
                case UPDATED -> sb.append("  - ").append(map.get(FIELD)).append(": ")
                        .append(map.get(OLD_VALUE)).append(System.lineSeparator())
                        .append("  + ").append(map.get(FIELD)).append(": ")
                        .append(map.get(NEW_VALUE)).append(System.lineSeparator());
                case REMOVED -> sb.append("  - ").append(map.get(FIELD)).append(": ")
                        .append(map.get(OLD_VALUE)).append(System.lineSeparator());
                case ADDED -> sb.append("  + ").append(map.get(FIELD)).append(": ")
                        .append(map.get(NEW_VALUE)).append(System.lineSeparator());
                default -> throw new RuntimeException("Unhandled status " + status);
            }
        }
        return sb.append("}").toString();
    }
}
