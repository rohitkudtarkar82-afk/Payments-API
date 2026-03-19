package Payments.Group.Payments.DTO;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PhoneRequestDTO {
    private UUID id;
    
    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("national_number")
    private String national_number;

    @JsonProperty("extension_number")
    private String extension_number;
    
}
