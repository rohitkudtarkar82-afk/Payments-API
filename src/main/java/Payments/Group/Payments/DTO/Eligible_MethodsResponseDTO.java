package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Eligible_MethodsResponseDTO {

    @JsonProperty("paypal")
    private PaypalResponseDTO paypal;

    @JsonProperty("venmo")
    private VenmoResponseDTO venmo;

    @JsonProperty("paypal_Credit")
    private Paypal_CreditResponseDTO paypal_Credit;

    @JsonProperty("paypal_Pay_Later")
    private Paypal_Pay_LaterResponseDTO paypal_Pay_Later;

    
    
}
