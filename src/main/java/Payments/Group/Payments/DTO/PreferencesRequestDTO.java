package Payments.Group.Payments.DTO;



import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PreferencesRequestDTO {
    @JsonProperty("payment_flow")
    private String payment_flow;

    @JsonProperty("include_account_details")
    private Boolean include_account_details;

    @JsonProperty("include_vault_tokens")
    private Boolean include_vault_tokens;

    @JsonProperty("payment_source_constraints")
    private List<Payment_Source_ConstraintRequestDTO> payment_source_constraints;

   
}
