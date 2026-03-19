package Payments.Group.Payments.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Paypal_Pay_Later")
@NoArgsConstructor
@AllArgsConstructor
public class Paypal_Pay_Later {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "can_be_vaulted")
    private Boolean can_be_vaulted;

    @Column(name = "country_code")
    private String country_code;

    @Column(name = "product_code")
    private String product_code;

}
