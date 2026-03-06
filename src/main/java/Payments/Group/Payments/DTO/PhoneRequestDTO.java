package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequestDTO {

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("national_number")
    private String national_number;

    @JsonProperty("extension_number")
    private String extension_number;
    
}
