package Payments.Group.Payments.DTO;


import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_InstructionRequestDTO {

    @JsonProperty("disbursement_mode")
    private String disbursement_mode;

    @JsonProperty("platform_Fees")
    private Platform_FeesRequestDTO platform_Fees;
    
}
