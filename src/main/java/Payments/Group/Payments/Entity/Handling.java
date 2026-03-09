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
public class Handling {

    @Id
    @Column(nullable = true)
    private String currency_code;

    @Column(nullable = true)
    private String value;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "tax_Total_id")
    private Tax_Total tax_Total;

}
