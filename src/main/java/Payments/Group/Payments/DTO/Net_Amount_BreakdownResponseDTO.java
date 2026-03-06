package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Net_Amount_BreakdownResponseDTO {

    @JsonProperty("payable_Amount")
    private Payable_AmountResponseDTO payable_Amount;

    @JsonProperty("converted_Amount")
    private Converted_AmountResponseDTO converted_Amount;

    @JsonProperty("exchange_Rate")
    private Exchange_RateResponseDTO exchange_Rate;
    
}
