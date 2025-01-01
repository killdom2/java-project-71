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

public class Plain {
    public static String format(List<Map<Fields, Object>> differences) {

        StringBuilder sb = new StringBuilder();
        for (Map<Fields, Object> map : differences) {
            var status = map.get(STATUS);
            map.put(NEW_VALUE, instanceOf(map.get(NEW_VALUE)));
            map.put(OLD_VALUE, instanceOf(map.get(OLD_VALUE)));

            switch (status)  {
                case SAME -> { }
                case UPDATED -> sb.append("Property '").append(map.get(FIELD))
                        .append("' was updated. From ").append(map.get(OLD_VALUE))
                        .append(" to ").append(map.get(NEW_VALUE))
                        .append(System.lineSeparator());
                case REMOVED -> sb.append("Property '").append(map.get(FIELD)).append("' was removed")
                        .append(System.lineSeparator());
                case ADDED -> sb.append("Property '").append(map.get(FIELD)).append("' was added with value: ")
                        .append(map.get(NEW_VALUE)).append(System.lineSeparator());
                default -> throw new RuntimeException("Unhandled status " + status);
            }
        }
        return sb.toString();
    }

    private static String instanceOf(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof Boolean || value instanceof Number) {
            return value.toString();
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return "[complex value]";
    }
}
