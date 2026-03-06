package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Network_Transaction_ReferenceResponseDTO {

    @JsonProperty("id")
    private UUID id;

    @JsonProperty("date")
    private String date;

    @JsonProperty("network")
    private String network;

    @JsonProperty("acquirer_reference_number")
    private String acquirer_reference_number;

}
