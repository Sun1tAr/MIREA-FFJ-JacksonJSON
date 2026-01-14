package my.learn.utils;

import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import my.learn.model.CurrencyCharCode;

import java.io.IOException;

public class CurrencyCharCodeKeyDeserializer extends KeyDeserializer {

    @Override
    public CurrencyCharCode deserializeKey(String s, DeserializationContext deserializationContext) throws IOException {
        try {
            return CurrencyCharCode.valueOf(s);
        } catch (IllegalArgumentException e) {
            return CurrencyCharCode.UNEXPECTED;
        }
    }
}
