package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypal_CreditResponseDTO {
    private UUID id;
    
    @JsonProperty("can_be_vaulted")
    private Boolean can_be_vaulted;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("product_code")
    private String product_code;

    @JsonProperty("paypal_Pay_Later")
    private Paypal_Pay_LaterResponseDTO paypal_Pay_Later;
    
}
