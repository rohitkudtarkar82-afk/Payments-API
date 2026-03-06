package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capture_PaymentRequestDTO {

    @JsonProperty("invoice_id")
    private String invoice_id;

    @JsonProperty("note_to_payer")
    private String note_to_payer;

    @JsonProperty("amount")
    private AmountRequestDTO amount;

    @JsonProperty("final_capture")
    private String final_capture;

    @JsonProperty("payment_instruction")
    private Payment_InstructionRequestDTO payment_instruction;

    @JsonProperty("soft_descriptor")
    private String soft_descriptor;
    
}
