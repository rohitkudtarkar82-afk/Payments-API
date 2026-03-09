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
public class Venmo {

    @Id
    @Column(nullable = true)
    private String can_be_vaulted;

    @Column(nullable = true)
    private String country_code;

    @Column(nullable = true)
    private String product_code;

    @Column(nullable = true)
    private String eligible_in_paypal_network;

    @Column(nullable = true)
    private String recommended;

    @Column(nullable = true)
    private String recommended_priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paypal_Credit_id")
    private Paypal_Credit paypal_Credit;
}
