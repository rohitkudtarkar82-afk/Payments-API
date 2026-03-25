package Payments.Group.Payments.DTO;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Capture_PaymentResponseDTO {

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_Details")
    private Status_DetailsResponseDTO status_Details;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("amount")
    private AmountResponseDTO amount;

    @JsonProperty("invoice_id")
    private UUID invoice_id;

    @JsonProperty("custom_id")
    private UUID custom_id;

    @JsonProperty("network_Transaction_Reference")
    private Network_Transaction_ReferenceResponseDTO network_Transaction_Reference;

    @JsonProperty("seller_Protection")
    private Seller_ProtectionResponseDTO seller_Protection;

    @JsonProperty("final_capture")
    private String final_capture;

    @JsonProperty("seller_Receivable_Breakdown")
    private Seller_Receivable_BreakdownResponseDTO seller_Receivable_Breakdown;

    @JsonProperty("disbursement_mode")
    private String disbursement_mode;

    @JsonProperty("links")
    private List<LinksResponseDTO> links;

    @JsonProperty("processor_Response")
    private Processor_ResponseResponseDTO processor_Response;

    @JsonProperty("create_time")
    private Instant create_time;

    @JsonProperty("update_time")
    private Instant update_time;

    @JsonProperty("supplementary_Data")
    private Supplementary_DataResponseDTO supplementary_Data;

    @JsonProperty("payee")
    private PayeeResponseDTO payee;

    

    
    
}
