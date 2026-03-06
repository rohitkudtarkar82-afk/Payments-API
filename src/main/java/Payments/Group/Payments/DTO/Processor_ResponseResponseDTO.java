package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Processor_ResponseResponseDTO {

    @JsonProperty("avs_code")
    private String avs_code;

    @JsonProperty("cvv_code")
    private String cvv_code;

    @JsonProperty("response_code")
    private String response_code;

    @JsonProperty("payment_advice_code")
    private String payment_advice_code;
    
}
