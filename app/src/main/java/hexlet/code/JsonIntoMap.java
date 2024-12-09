package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

class JsonIntoMap {
    @SuppressWarnings("CallToPrintStackTrace")
    JsonObject convert(String file) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        JsonObject jsonObject = null;

        try {
            jsonObject = objectMapper.readValue(file, JsonObject.class);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        }
        System.out.println(jsonObject);
        return jsonObject;
    }
}
