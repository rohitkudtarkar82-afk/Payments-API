package Payments.Group.Payments.DTO;

import java.util.List;

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
    private String id;

    @JsonProperty("amount")
    private AmountResponseDTO amount;

    @JsonProperty("invoice_id")
    private String invoice_id;

    @JsonProperty("custom_id")
    private String custom_id;

    @JsonProperty("acquirer_reference_number")
    private String acquirer_reference_number;

    @JsonProperty("note_to_payer")
    private String note_to_payer;

    @JsonProperty("seller_Payable_Breakdown")
    private Seller_Payable_BreakdownResponseDTO seller_Payable_Breakdown;

    @JsonProperty("payer")
    private PayerResponseDTO payer;

    @JsonProperty("link")
    private List<LinkResponseDTO> link;

    @JsonProperty("create_time")
    private String create_time;

    @JsonProperty("update_time")
    private String update_time;

    
}
