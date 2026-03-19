package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Net_Amount_Receivable_CurrencyResponseDTO {
    private UUID id;
    
    @JsonProperty("currency_code")
    private String currency_code;

    @JsonProperty("value")
    private String value;

    @JsonProperty("total_Refunded_Amount")
    private Total_Refunded_AmountResponseDTO total_Refunded_Amount;


    
}
