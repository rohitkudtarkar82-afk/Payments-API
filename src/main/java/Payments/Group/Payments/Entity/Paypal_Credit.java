package Payments.Group.Payments.Entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paypal_Credit {
    public static Paypal_Credit paypal_Credit;
    @Id
    @Column(nullable = true)
    private String can_be_vaulted;

    @Column(nullable = true)
    private String country_code;

    @Column(nullable = true)
    private String product_code;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paypal_Pay_Later_id")
    private Paypal_Pay_Later paypal_Pay_Later;
}
