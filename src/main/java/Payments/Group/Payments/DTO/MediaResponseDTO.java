package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MediaResponseDTO {
    private UUID id;
    
    @JsonProperty("type")
    private String type;

    @JsonProperty("binaryEncoding")
    private String binaryEncoding;
    
}
