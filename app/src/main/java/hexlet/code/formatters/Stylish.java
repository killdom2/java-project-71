package hexlet.code.formatters;

import hexlet.code.common.Field;
import hexlet.code.common.Status;

import java.util.List;
import java.util.Map;

public class Stylish {
    public static String format(List<Map<Field, Object>> differences) {

        StringBuilder sb = new StringBuilder();
        sb.append("{").append(System.lineSeparator());

        for (Map<Field, Object> map : differences) {
            var status = map.get(Field.STATUS);
            switch (status)  {
                case Status.SAME -> sb.append(String.format(
                        "    %s: %s%n", map.get(Field.FIELD), map.get(Field.OLD_VALUE)));
                case Status.UPDATED -> sb.append(String.format(
                        "  - %s: %s%n  + %s: %s%n",
                                map.get(Field.FIELD), map.get(Field.OLD_VALUE),
                                map.get(Field.FIELD), map.get(Field.NEW_VALUE)));
                case Status.REMOVED -> sb.append(String.format(
                        "  - %s: %s%n", map.get(Field.FIELD), map.get(Field.OLD_VALUE)));
                case Status.ADDED -> sb.append(String.format(
                        "  + %s: %s%n", map.get(Field.FIELD), map.get(Field.NEW_VALUE)));
                default -> throw new RuntimeException("Unhandled status " + status);
            }
        }
        return sb.append("}").toString();
    }
}
