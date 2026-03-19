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
@Table(name = "Net_Amount")
@NoArgsConstructor
@AllArgsConstructor
public class Net_Amount {
    
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "currency_code")
    private String currency_code;

    @Column(name = "value")
    private String value;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receivable_Amount_id")
    private Receivable_Amount receivable_Amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "net_Amount_Receivable_Currency_id")
    private Net_Amount_Receivable_Currency net_Amount_Receivable_Currency;

}
