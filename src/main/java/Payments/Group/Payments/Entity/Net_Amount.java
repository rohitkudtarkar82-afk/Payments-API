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
public class Net_Amount {
    public static Net_Amount net_Amount;
    @Id
    @Column(nullable = true)
    private String currency_code;

    @Column(nullable = true)
    private String value;
    
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "receivable_Amount_id")
    private Receivable_Amount receivable_Amount;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "net_Amount_Receivable_Currency_id")
    private Net_Amount_Receivable_Currency net_Amount_Receivable_Currency;

}
