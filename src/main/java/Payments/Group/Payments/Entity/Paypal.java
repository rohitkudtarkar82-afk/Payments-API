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
@Table(name = "Paypal")
@NoArgsConstructor
@AllArgsConstructor
public class Paypal {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "can_be_vaulted")
    private Boolean can_be_vaulted;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "product_code")
    private String product_code;

    @Column(name = "eligible_in_paypal_network")
    private Boolean eligible_in_paypal_network;

    @Column(name = "recommended")
    private Boolean recommended;

    @Column(name = "recommended_priority")
    private Integer recommended_priority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "venmo_id")
    private Venmo venmo;

    public void setCan_be_vaulted(Object can_be_vaulted2) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setCan_be_vaulted'");
    }

}
