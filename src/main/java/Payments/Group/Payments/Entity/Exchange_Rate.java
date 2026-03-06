package Payments.Group.Payments.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exchange_Rate {
    public static Exchange_Rate exchange_Rate;
    @Id
    @Column(nullable = true)
    private String source_currency;

    @Column(nullable = true)
    private String target_currency;

    @Column(nullable = true)
    private String value;

}
