package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Source_VenmoResponseDTO {
    private UUID id;
    
    @JsonProperty("user_name")
    private String user_name;

   
}
