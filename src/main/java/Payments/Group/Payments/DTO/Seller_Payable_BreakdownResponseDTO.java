package Payments.Group.Payments.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller_Payable_BreakdownResponseDTO {

    @JsonProperty("gross_Amount")
    private Gross_AmountResponseDTO gross_Amount;

    @JsonProperty("paypal_Fee")
    private Paypal_FeeResponseDTO paypal_Fee;
    
    @JsonProperty("paypal_Fee_Receivable_Currency")
    private Paypal_Fee_Receivable_CurrencyResponseDTO paypal_Fee_Receivable_Currency;

    @JsonProperty("net_Amount")
    private Net_AmountResponseDTO net_Amount;

    @JsonProperty("net_Amount_Receivable_Currency")
    private Net_Amount_Receivable_CurrencyResponseDTO net_Amount_Receivable_Currency;

    @JsonProperty("platform_Fees")
    private List<Platform_FeesResponseDTO> platform_Fees;

    @JsonProperty("net_Amount_Breakdown")
    private List<Net_Amount_BreakdownResponseDTO> net_Amount_Breakdown;

    @JsonProperty("total_Refunded_Amount")
    private Total_Refunded_AmountResponseDTO total_Refunded_Amount;

}
