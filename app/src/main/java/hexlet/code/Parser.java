package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class Parser {
    @SuppressWarnings({})
    static Map<String, Object> convertJson(String file) throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> map = null;

        try {
            map = objectMapper.readValue(file, new TypeReference<>() { });
        } catch (JsonMappingException e) {
            System.out.println("File not found");
        }
        return map;
    }

    static Map<String, Object> convertYaml(String yaml) {

        Yaml yamlString = new Yaml();
        return yamlString.load(yaml);
    }
}
