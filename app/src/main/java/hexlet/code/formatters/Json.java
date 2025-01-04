package hexlet.code.formatters;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import hexlet.code.Fields;

import java.util.List;
import java.util.Map;

public class Json {

    @JsonPropertyOrder({"FIELD", "STATUS", "OLD_VALUE", "NEW_VALUE"})
    public static String format(List<Map<Fields, Object>> differences) throws JsonProcessingException {

        ObjectWriter objectWriter = new ObjectMapper().writer()
                .with(SerializationFeature.ORDER_MAP_ENTRIES_BY_KEYS)
                .withDefaultPrettyPrinter();
        return objectWriter.writeValueAsString(differences);
    }
}
