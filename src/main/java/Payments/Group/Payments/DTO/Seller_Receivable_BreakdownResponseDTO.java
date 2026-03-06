package Payments.Group.Payments.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller_Receivable_BreakdownResponseDTO {

    @JsonProperty("gross_Amount")
    private Gross_AmountResponseDTO gross_Amount;

    @JsonProperty("paypal_Fee")
    private Paypal_FeeResponseDTO paypal_Fee;

    @JsonProperty("paypal_Fee_Receivable_Currency")
    private Paypal_Fee_Receivable_CurrencyResponseDTO paypal_Fee_Receivable_Currency;

    @JsonProperty("net_Amount")
    private Net_AmountResponseDTO net_Amount;

    @JsonProperty("receivable_Amount")
    private Receivable_AmountResponseDTO receivable_Amount;

    @JsonProperty("exchange_Rate")
    private Exchange_RateResponseDTO exchange_Rate;

    @JsonProperty("platform_Fees")
    private List<Platform_FeesResponseDTO> platform_Fees;

    
}
