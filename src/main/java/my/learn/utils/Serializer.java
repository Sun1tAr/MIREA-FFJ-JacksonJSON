package my.learn.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.InstantDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.ZonedDateTimeSerializer;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Serializer {

    private static ObjectMapper mapper;

    public static ObjectMapper getMapper() {
        if (mapper == null) {
            mapper = new ObjectMapper();

            // Часовой пояс Москвы
            ZoneId moscowZone = ZoneId.of("Europe/Moscow");

            // Формат с часовым поясом Москвы
            DateTimeFormatter moscowFormatter = DateTimeFormatter
                    .ofPattern("yyyy-MM-dd'T'HH:mm:ssXXX")
                    .withZone(moscowZone);

            JavaTimeModule javaTimeModule = new JavaTimeModule();

            // Настраиваем сериализатор для Moscow времени
            javaTimeModule.addSerializer(ZonedDateTime.class,
                    new ZonedDateTimeSerializer(moscowFormatter));

            // Настраиваем десериализатор (сохраняем исходный часовой пояс)
            javaTimeModule.addDeserializer(ZonedDateTime.class,
                    InstantDeserializer.ZONED_DATE_TIME);

            mapper.registerModule(javaTimeModule);
            mapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        }
        return mapper;
    }


}
