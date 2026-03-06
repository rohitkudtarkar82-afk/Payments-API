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
public class Discount {
    public static Discount discount;
    @Id
    @Column(nullable = true)
    private String currency_code;

    @Column(nullable = true)
    private String value;

}
