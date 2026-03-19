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
@Table(name = "Payable_Amount")
@NoArgsConstructor
@AllArgsConstructor
public class Payable_Amount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "currency_code")
    private String currency_code;

    @Column(name = "value")
    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "converted_Amount_id")
    private Converted_Amount converted_Amount;
}
