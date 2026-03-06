package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreakdownResponseDTO {

    @JsonProperty("item_Total")
    private Item_TotalResponseDTO item_Total;

    @JsonProperty("shipping")
    private ShippingResponseDTO shipping;

    @JsonProperty("handling")
    private HandlingResponseDTO handling;

    @JsonProperty("tax_Total")
    private Tax_TotalResponseDTO tax_Total;

    @JsonProperty("insurance")
    private InsuranceResponseDTO insurance;

    @JsonProperty("shipping_Discount")
    private Shipping_DiscountResponseDTO shipping_Discount;

    @JsonProperty("discount")
    private DiscountResponseDTO discount;

}
