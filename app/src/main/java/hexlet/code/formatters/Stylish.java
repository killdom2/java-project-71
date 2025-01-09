package hexlet.code.formatters;

import hexlet.code.common.Field;

import java.util.List;
import java.util.Map;

import static hexlet.code.common.Field.FIELD;
import static hexlet.code.common.Field.STATUS;
import static hexlet.code.common.Field.OLD_VALUE;
import static hexlet.code.common.Field.NEW_VALUE;
import static hexlet.code.common.Status.ADDED;
import static hexlet.code.common.Status.SAME;
import static hexlet.code.common.Status.UPDATED;
import static hexlet.code.common.Status.REMOVED;

public class Stylish {
    public static String format(List<Map<Field, Object>> differences) {

        StringBuilder sb = new StringBuilder();
        sb.append("{").append(System.lineSeparator());

        for (Map<Field, Object> map : differences) {
            var status = map.get(STATUS);
            switch (status)  {
                case SAME -> sb.append(String.format(
                        "%s%s: %s", (" ").repeat(4), map.get(FIELD), map.get(OLD_VALUE)))
                        .append(System.lineSeparator());
                case UPDATED -> sb.append(String.format("  - %s: %s", map.get(FIELD), map.get(OLD_VALUE)))
                        .append(System.lineSeparator())
                        .append(String.format("  + %s: %s", map.get(FIELD), map.get(NEW_VALUE)))
                        .append(System.lineSeparator());
                case REMOVED -> sb.append(String.format("  - %s: %s", map.get(FIELD), map.get(OLD_VALUE)))
                        .append(System.lineSeparator());
                case ADDED -> sb.append(String.format("  + %s: %s", map.get(FIELD), map.get(NEW_VALUE)))
                        .append(System.lineSeparator());
                default -> throw new RuntimeException("Unhandled status " + status);
            }
        }
        return sb.append("}").toString();
    }
}
