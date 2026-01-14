package my.learn.utils;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import my.learn.model.CurrencyCharCode;

import java.io.IOException;

public class CurrencyCharCodeDeserializer extends JsonDeserializer<CurrencyCharCode> {
    @Override
    public CurrencyCharCode deserialize(JsonParser jsonParser, DeserializationContext deserializationContext)
            throws IOException {

        String charCode = jsonParser.getValueAsString();
        if (charCode == null || charCode.isEmpty()) {
            return CurrencyCharCode.UNEXPECTED;
        }

        try {
            return CurrencyCharCode.valueOf(charCode);
        } catch (IllegalArgumentException e) {
            return CurrencyCharCode.UNEXPECTED;
        }

    }
}
