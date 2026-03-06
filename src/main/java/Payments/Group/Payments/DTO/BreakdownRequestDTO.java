package Payments.Group.Payments.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BreakdownRequestDTO {

    @JsonProperty("item_Total")
    private Item_TotalRequestDTO item_Total;

    @JsonProperty("shipping")
    private ShippingRequestDTO shipping;

    @JsonProperty("handling")
    private HandlingRequestDTO handling;

    @JsonProperty("tax_Total")
    private Tax_TotalRequestDTO tax_Total;

    @JsonProperty("insurance")
    private InsuranceRequestDTO insurance;

    @JsonProperty("shipping_Discount")
    private Shipping_DiscountRequestDTO shipping_Discount;

    @JsonProperty("discount")
    private DiscountRequestDTO discount;

}
