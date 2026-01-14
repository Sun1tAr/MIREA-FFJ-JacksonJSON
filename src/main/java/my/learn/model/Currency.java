package my.learn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import my.learn.utils.CurrencyCharCodeDeserializer;


@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @NoArgsConstructor
public class Currency {

    @JsonProperty(value = "ID")
    private String id;

    @JsonProperty(value = "NumCode")
    private Integer numCode;

    @JsonProperty(value = "CharCode")
    @JsonDeserialize(using = CurrencyCharCodeDeserializer.class)
    private CurrencyCharCode charCode;

    @JsonProperty(value = "Nominal")
    private Integer nominal;

    @JsonProperty(value = "Name")
    private String name;

    @JsonProperty(value = "Value")
    private Double value;



}
