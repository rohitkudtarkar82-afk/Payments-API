package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChannelRequestDTO {

    @JsonProperty("browser_type")
    private String browser_type;

    @JsonProperty("client_os")
    private String client_os;

    @JsonProperty("device_type")
    private String device_type;

   

}
