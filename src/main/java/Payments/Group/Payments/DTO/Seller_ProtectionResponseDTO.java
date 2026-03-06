package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Seller_ProtectionResponseDTO {

    @JsonProperty("status")
    private String status;

    @JsonProperty("dispute_categories")
    private String disputeCategories;
    
}
