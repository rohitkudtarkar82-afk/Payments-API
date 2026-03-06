package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Source_ConstraintRequestDTO {

    @JsonProperty("constraint_type")
    private String constraint_type;

    @JsonProperty("payment_sources")
    private String payment_sources;

}
