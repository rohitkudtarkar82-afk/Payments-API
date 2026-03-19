package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tax_TotalResponseDTO {

    private UUID id;

    @JsonProperty("currency_code")
    private String currency_Code;

    @JsonProperty("value")
    private String value;

    @JsonProperty("insurance")
    private InsuranceResponseDTO insurance;

}
