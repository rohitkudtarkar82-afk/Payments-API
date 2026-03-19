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
@Table(name = "Net_Amount_Receivable_Currency")
@NoArgsConstructor
@AllArgsConstructor
public class Net_Amount_Receivable_Currency {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "currency_code")
    private String currency_code;
    
    @Column(name = "value")
    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "total_Refunded_Amount_id")
    private Total_Refunded_Amount total_Refunded_Amount;

}
