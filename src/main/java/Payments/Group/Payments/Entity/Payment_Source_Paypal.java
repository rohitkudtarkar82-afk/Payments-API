package Payments.Group.Payments.Entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Payment_Source_Paypal {
    public static Payment_Source_Paypal payment_Source_Paypal;
    @Column(nullable = true)
    private String email_address;

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID payer_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_Source_Venmo_id")
    private Payment_Source_Venmo payment_Source_Venmo;

}
