package Payments.Group.Payments.DTO;

import java.util.List;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_TokensResponseDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("links")
    private List<LinksResponseDTO> links;

    @JsonProperty("payment_Source")
    private Payment_SourceResponseDTO payment_Source;
    
}
