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
@Table(name = "venmo")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Venmo {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "can_be_vaulted")
    private Boolean canBeVaulted;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "product_code")
    private String productCode;

    @Column(name = "eligible_in_paypal_network")
    private Boolean eligibleInPaypalNetwork;

    @Column(name = "recommended")
    private Boolean recommended;

    @Column(name = "recommended_priority")
    private Integer recommendedPriority;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "paypal_credit_id")
    private Paypal_Credit paypalCredit;
}
