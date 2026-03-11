package Payments.Group.Payments.DTO;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Show_Details_PaymentResponseDTO {

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

    @JsonProperty("network_Transaction_Reference")
    private Network_Transaction_ReferenceResponseDTO network_Transaction_Reference;

    @JsonProperty("seller_Protection")
    private Seller_ProtectionResponseDTO seller_Protection;

    @JsonProperty("expiration_time")
    private String expiration_time;

    @JsonProperty("link")
    private List<LinkResponseDTO> link;

    @JsonProperty("create_time")
    private String create_time;

    @JsonProperty("update_time")
    private String update_time;

    @JsonProperty("supplementary_Data")
    private Supplementary_DataResponseDTO supplementary_Data;

    @JsonProperty("payee")
    private PayeeResponseDTO payee;

}
