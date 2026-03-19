package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Net_AmountResponseDTO {
    private UUID id;
    
    @JsonProperty("currency_code")
    private String currency_code;

    @JsonProperty("value")
    private String value;

    @JsonProperty("receivable_amount")
    private Receivable_AmountResponseDTO receivable_Amount;

    @JsonProperty("net_Amount_Receivable_Currency")
    private Net_Amount_Receivable_CurrencyResponseDTO net_Amount_Receivable_Currency;

}
