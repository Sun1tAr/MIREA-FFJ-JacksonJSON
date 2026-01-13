package my.learn.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

public class Serializer {

    private static ObjectMapper mapper;

    public static ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper().registerModule(new JavaTimeModule());
            //todo
            // разобраться с парсингом дат
        }
        return mapper;
    }

}
