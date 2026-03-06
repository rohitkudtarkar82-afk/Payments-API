package Payments.Group.Payments.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Preferences {
    public static Preferences preferences;
    @Id
    @Column(nullable = true)
    private String payment_flow;

    @Column(nullable = true)
    private String include_account_details;

    @Column(nullable = true)
    private String include_vault_tokens;
    
    @OneToMany(mappedBy = "preferences", cascade = CascadeType.ALL)
    private List<Payment_Source_Constraint> payment_Source_Constraints;
}
