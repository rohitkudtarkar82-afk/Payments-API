package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypal_FeeResponseDTO {

    @JsonProperty("currency_code")
    private String currency_code;

    @JsonProperty("value")
    private String value;

    @JsonProperty("paypal_Fee_Receivable_Currency")
    private Paypal_Fee_Receivable_CurrencyResponseDTO paypal_Fee_Receivable_Currency;
    
}
