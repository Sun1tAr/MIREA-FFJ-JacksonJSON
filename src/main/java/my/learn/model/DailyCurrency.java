package my.learn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor  @NoArgsConstructor
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
    private Map<String, Currency> valutes;


}


