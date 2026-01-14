package my.learn.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import my.learn.utils.CurrencyCharCodeDeserializer;
import my.learn.utils.CurrencyCharCodeKeyDeserializer;

import java.time.ZonedDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor  @NoArgsConstructor
@Getter
public class DailyCurrency {

    @JsonProperty(value = "Date")
    private ZonedDateTime date;

    @JsonProperty(value = "PreviousDate")
    private ZonedDateTime previousDate;

    @JsonProperty(value = "Timestamp")
    private ZonedDateTime timeStamp;

    @JsonProperty(value = "PreviousURL")
    private String previousUrl;

    @JsonProperty(value = "Valute")
    @JsonDeserialize(keyUsing = CurrencyCharCodeKeyDeserializer.class)
    private Map<CurrencyCharCode, Currency> valutes;


    @Override
    public String toString() {
        return "DailyCurrency{" +
                "date=" + date +
                ", previousDate=" + previousDate +
                ", timeStamp=" + timeStamp +
                '}';
    }
}


