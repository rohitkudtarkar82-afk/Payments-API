package Payments.Group.Payments.DTO;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_InstructionRequestDTO {


    @JsonProperty("payee_pricing_tier_id;")
    private String payee_pricing_tier_id;

    @JsonProperty("payee_receivable_fx_rate_id")
    private String payee_receivable_fx_rate_id;

    @JsonProperty("disbursement_mode")
    private String disbursement_mode;

    @JsonProperty("platform_Fees")
    private List<Platform_FeesRequestDTO> platform_Fees;

    public Payment_InstructionRequestDTO getPayment_instruction() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPayment_instruction'");
    }

}
