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
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Payment_Source_Paypal")
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Source_Paypal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "payer_id")
    private UUID payer_id;

    @Column(name = "email_address")
    private String email_address;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payment_Source_Venmo_id")
    private Payment_Source_Venmo payment_Source_Venmo;

   

}
