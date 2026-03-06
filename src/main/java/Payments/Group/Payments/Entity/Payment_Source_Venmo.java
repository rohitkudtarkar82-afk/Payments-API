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
public class Payment_Source_Venmo {
    public static Payment_Source_Venmo payment_Source_Venmo;
    @Id
    @Column(nullable = true)
    private String user_name;

}
