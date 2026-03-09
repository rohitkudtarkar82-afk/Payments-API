package Payments.Group.Payments.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypal_Pay_Later {
    
    @Id
    @Column(nullable = true)
    private String can_be_vaulted;

    @Column(nullable = true)
    private String country_code;

    @Column(nullable = true)
    private String product_code;

}
