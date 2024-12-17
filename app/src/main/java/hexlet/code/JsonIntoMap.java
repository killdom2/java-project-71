package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

class JsonIntoMap {
    @SuppressWarnings("CallToPrintStackTrace")
    static Map<String, Object> convert(String file) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = null;

        try {
            map = objectMapper.readValue(file, new TypeReference<>(){});
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        return map;
    }
}
