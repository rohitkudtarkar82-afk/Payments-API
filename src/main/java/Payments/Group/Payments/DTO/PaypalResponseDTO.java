package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalResponseDTO {

    @JsonProperty("can_be_vaulted")
    private String can_be_vaulted;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("product_code")
    private String product_code;

    @JsonProperty("eligible_in_paypal_network")
    private String eligible_in_paypal_network;

    @JsonProperty("recommended")
    private String recommended;

    @JsonProperty("recommended_priority")
    private String recommended_priority;

    @JsonProperty("venmo")
    private VenmoResponseDTO venmo;
    
}
