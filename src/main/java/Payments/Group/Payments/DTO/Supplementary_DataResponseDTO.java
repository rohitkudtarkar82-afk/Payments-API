package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data 
@NoArgsConstructor
@AllArgsConstructor
public class Supplementary_DataResponseDTO {

    @JsonProperty("related_Ids")
    private Related_IdsResponseDTO related_Ids;
    
}
