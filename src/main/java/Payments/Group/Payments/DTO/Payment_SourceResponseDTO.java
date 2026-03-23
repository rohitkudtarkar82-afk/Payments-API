package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_SourceResponseDTO {

    @JsonProperty("payment_Source_Paypal")
    private Payment_Source_PaypalResponseDTO payment_Source_Paypal;

    @JsonProperty("payment_Source_Venmo")
    private Payment_Source_VenmoResponseDTO payment_Source_Venmo;

   
}
