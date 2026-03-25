package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Refund_Captured_PaymentRequestDTO {

    @JsonProperty("amount")
    private AmountRequestDTO amount;

    @JsonProperty("custom_id")
    private UUID custom_id;

    @JsonProperty("invoice_id")
    private UUID invoice_id;

    @JsonProperty("note_to_payer")
    private String note_to_payer;

    @JsonProperty("payment_Instruction")
    private Payment_InstructionRequestDTO payment_Instruction;

     // ✅ Correct Getter
    public AmountRequestDTO getAmount() {
        return amount;
    }

    // ✅ Correct Setter
    public void setAmount(AmountRequestDTO amount) {
        this.amount = amount;
    }

    public Payment_InstructionRequestDTO getPayment_instruction() {
        return payment_Instruction;
    }

    public void setPayment_instruction(Payment_InstructionRequestDTO payment_instruction) {
        this.payment_Instruction = payment_instruction;
    }
    
    
    
}
