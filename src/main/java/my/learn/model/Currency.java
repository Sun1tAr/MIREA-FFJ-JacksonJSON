package my.learn.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor @NoArgsConstructor
public class Currency {

    @JsonProperty(value = "ID")
    private String id;
    @JsonProperty(value = "NumCode")
    private Integer numCode;
    @JsonProperty(value = "CharCode")
    private String charCode; // todo сделать как Enum
    @JsonProperty(value = "Nominal")
    private Integer nominal;
    @JsonProperty(value = "Name")
    private String name;
    @JsonProperty(value = "Value")
    private Double value;



}
