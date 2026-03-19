package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import Payments.Group.Payments.Entity.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LinksResponseDTO {
    private UUID id;

    @JsonProperty("href")
    private String href;

    @JsonProperty("rel")
    private String rel;

    @JsonProperty("method")
    private String method;

    @JsonProperty("title")
    private String title;

    @JsonProperty("media_type")
    private String mediaType;

    @JsonProperty("enc_type")
    private String encType;

    @JsonProperty("schema")
    private SchemaResponseDTO schema;

    @JsonProperty("target_Schema")
    private Target_SchemaResponseDTO target_Schema;
    
}
