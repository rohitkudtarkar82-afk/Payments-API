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

    public Status_DetailsResponseDTO getStatus_details() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getStatus_details'");
    }

    public Processor_ResponseResponseDTO getProcessor_response() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getProcessor_response'");
    }

    public Network_Transaction_ReferenceResponseDTO getNetwork_transaction_reference() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getNetwork_transaction_reference'");
    }
    
}
