package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShippingResponseDTO {

    @JsonProperty("currency_code")
    private String currency_code;

    @JsonProperty("value")
    private String value;

    @JsonProperty("handling")
    private HandlingResponseDTO handling;
    
}
