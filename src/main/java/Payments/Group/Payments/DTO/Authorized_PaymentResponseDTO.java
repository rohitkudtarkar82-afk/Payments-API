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
public class Authorized_PaymentResponseDTO {

    @JsonProperty("status")
    private String status;

    @JsonProperty("status_details")
    private Status_DetailsResponseDTO status_details;

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("amount")
    private AmountResponseDTO amount;

    @JsonProperty("invoice_id")
    private UUID invoice_id;

    @JsonProperty("custom_id")
    private UUID custom_id;

    @JsonProperty("network_transaction_reference")
    private Network_Transaction_ReferenceResponseDTO network_transaction_reference;

    @JsonProperty("seller_protection")
    private Seller_ProtectionResponseDTO seller_protection;

    @JsonProperty("expiration_time")
    private Instant expiration_time;

    @JsonProperty("links")
    private List<LinksResponseDTO> links;

    @JsonProperty("create_time")
    private Instant create_time;

    @JsonProperty("update_time")
    private Instant update_time;

    @JsonProperty("supplementary_Data")
    private Supplementary_DataResponseDTO supplementary_Data;

    @JsonProperty("payee")
    private PayeeResponseDTO payee;

    
    
}
