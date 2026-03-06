package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequestDTO {

    @JsonProperty("country_code")
    private String country_code;

    @JsonProperty("email")
    private String email;

    @JsonProperty("channel")
    private ChannelRequestDTO channel;

    @JsonProperty("phone")
    private PhoneRequestDTO phone;

}
