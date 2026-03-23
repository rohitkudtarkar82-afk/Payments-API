package Payments.Group.Payments.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class List_Eligible_PaymentResponseDTO {

    @JsonProperty("eligible_Methods")
    private Eligible_MethodsResponseDTO eligible_Methods;

    @JsonProperty("payment_Tokens")
    private List<Payment_TokensResponseDTO> payment_Tokens;
    
}
