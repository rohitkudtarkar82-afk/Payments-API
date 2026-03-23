package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PaypalResponseDTO {

    @JsonProperty("can_be_vaulted")
    private Boolean can_be_vaulted;

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("product_code")
    private String product_code;

    @JsonProperty("eligible_in_paypal_network")
    private Boolean eligible_in_paypal_network;

    @JsonProperty("recommended")
    private Boolean recommended;

    @JsonProperty("recommended_priority")
    private Integer recommended_priority;
}