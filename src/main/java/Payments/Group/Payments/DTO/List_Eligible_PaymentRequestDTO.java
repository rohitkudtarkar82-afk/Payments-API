package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class List_Eligible_PaymentRequestDTO {

    @JsonProperty("customer")
    private CustomerRequestDTO customer;

    @JsonProperty("purchase_Units")
    private Purchase_UnitsRequestDTO purchase_Units;

    @JsonProperty("preferences")
    private PreferencesRequestDTO preferences;

   
    
}
