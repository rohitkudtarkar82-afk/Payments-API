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
public class Show_Refund_DetailsResponseDTO {

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

    @JsonProperty("acquirer_reference_number")
    private String acquirer_reference_number;

    @JsonProperty("note_to_payer")
    private String note_to_payer;

    @JsonProperty("seller_Payable_Breakdown")
    private Seller_Payable_BreakdownResponseDTO seller_Payable_Breakdown;

    @JsonProperty("payer")
    private PayerResponseDTO payer;

    @JsonProperty("links")
    private List<LinksResponseDTO> links;

    @JsonProperty("create_time")
    private Instant create_time;

    @JsonProperty("update_time")
    private Instant update_time;

    
}
