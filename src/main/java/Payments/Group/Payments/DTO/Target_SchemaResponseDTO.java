package Payments.Group.Payments.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Target_SchemaResponseDTO {

    @JsonProperty("additionalItems")
    private String additionalItems;

    @JsonProperty("items")
    private String items;

    @JsonProperty("definitions")
    private String definitions;

    @JsonProperty("patternProperties")
    private String patternProperties;

    @JsonProperty("properties")
    private String properties;

    @JsonProperty("allOf")
    private String allOf;

    @JsonProperty("anyOf")
    private String anyOf;

    @JsonProperty("oneOf")
    private String oneOf;

    @JsonProperty("notValue")
    private String notValue;

    @JsonProperty("links1")
    private String links1;

    @JsonProperty("fragmentResolution")
    private String fragmentResolution;

    @JsonProperty("pathStart")
    private String pathStart;

    @JsonProperty("media")
    private MediaResponseDTO media;

    @JsonProperty("links")
    private List<LinksResponseDTO> links;

}
