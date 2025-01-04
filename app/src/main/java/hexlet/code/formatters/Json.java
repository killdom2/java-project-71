package hexlet.code.formatters;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import hexlet.code.Fields;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Json {
    public static String format(List<Map<Fields, Object>> differences) throws JsonProcessingException {

//        StringBuilder sb = new StringBuilder();
//        sb.append("[").append(System.lineSeparator());
        ObjectWriter objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();

//        Iterator<Map<Fields, Object>> iter = differences.iterator();
//
//        while (iter.hasNext()) {
//
//            Map<Fields, Object> map = iter.next();
//
//            sb.append(objectWriter.writeValueAsString(map));
//            if (iter.hasNext()) {
//                sb.append(", ").append(System.lineSeparator());
//            }
//        }
//        sb.append(System.lineSeparator()).append("]");
//        return sb.toString();
        return objectWriter.writeValueAsString(differences);
    }
}
