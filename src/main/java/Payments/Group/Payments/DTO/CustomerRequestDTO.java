package Payments.Group.Payments.DTO;

import java.util.UUID;

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

    public UUID getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void setBrowser_type(String browser_type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setBrowser_type'");
    }

    public void setClient_os(String client_os) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setClient_os'");
    }

    public void setDevice_type(String device_type) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setDevice_type'");
    }

}
