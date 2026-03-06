package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypal_Pay_LaterResponseDTO {

    @JsonProperty("can_be_vaulted")
    private String can_be_vaulted;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("product_code")
    private String product_code;
    
}
