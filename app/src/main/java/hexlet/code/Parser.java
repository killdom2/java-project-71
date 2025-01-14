package hexlet.code;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

import java.util.Map;

public class Parser {

    static Map<String, Object> parse(String file, String extension) throws JsonProcessingException {

        return switch (extension) {
            case "json" -> convertJson(file);
            case "yaml", "yml" -> convertYaml(file);
            default -> throw new RuntimeException("Unsupported extension: " + extension);
        };
    }

    static Map<String, Object> convertJson(String json) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(json, new TypeReference<>() { });
    }

    static Map<String, Object> convertYaml(String yaml) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper(new YAMLFactory());
        return objectMapper.readValue(yaml, new TypeReference<>() { });
    }
}
