package Payments.Group.Payments.Entity;


import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Preferences")
@NoArgsConstructor
@AllArgsConstructor
public class Preferences {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "payment_flow")
    private String payment_flow;

    @Column(name = "include_account_details")
    private Boolean include_account_details;

    @Column(name = "include_vault_tokens")
    private Boolean include_vault_tokens;

    @OneToMany(mappedBy = "preferences", cascade = CascadeType.ALL)
    private List<Payment_Source_Constraint> payment_Source_Constraints;

   
}
