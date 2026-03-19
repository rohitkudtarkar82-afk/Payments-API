package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exchange_RateResponseDTO {
    private UUID id;
    
    @JsonProperty("source_currency")
    private String source_currency;

    @JsonProperty("target_currency")
    private String target_currency;
    
    @JsonProperty("value")
    private String value;
    
}
