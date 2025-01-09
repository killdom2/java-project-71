package hexlet.code.formatters;

import hexlet.code.common.Field;

import java.util.List;
import java.util.Map;

import static hexlet.code.common.Field.FIELD;
import static hexlet.code.common.Field.NEW_VALUE;
import static hexlet.code.common.Field.OLD_VALUE;
import static hexlet.code.common.Field.STATUS;
import static hexlet.code.common.Status.ADDED;
import static hexlet.code.common.Status.REMOVED;
import static hexlet.code.common.Status.SAME;
import static hexlet.code.common.Status.UPDATED;

public class Plain {
    public static String format(List<Map<Field, Object>> differences) {

        StringBuilder sb = new StringBuilder();
        for (Map<Field, Object> map : differences) {
            var status = map.get(STATUS);
            map.put(NEW_VALUE, instanceOf(map.get(NEW_VALUE)));
            map.put(OLD_VALUE, instanceOf(map.get(OLD_VALUE)));

            switch (status)  {
                case SAME -> { }
                case UPDATED -> sb.append(String.format(
                        "Property '%s' was updated. From %s to %s",
                                map.get(FIELD), map.get(OLD_VALUE), map.get(NEW_VALUE)))
                        .append(System.lineSeparator());
                case REMOVED -> sb.append(String.format(
                        "Property '%s' was removed",
                                map.get(FIELD)))
                        .append(System.lineSeparator());
                case ADDED -> sb.append(String.format(
                        "Property '%s' was added with value: %s",
                                map.get(FIELD), map.get(NEW_VALUE)))
                        .append(System.lineSeparator());
                default -> throw new RuntimeException("Unhandled status " + status);
            }
        }
        return sb.toString().trim();
    }

    private static String instanceOf(Object value) {
        if (value == null) {
            return "null";
        }
        if (value instanceof List<?> || value instanceof Map<?, ?>) {
            return "[complex value]";
        }
        if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
