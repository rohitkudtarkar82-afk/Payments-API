package Payments.Group.Payments.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID payee_pricing_tier_id;

    private UUID payee_receivable_fx_rate_id;

    @Column(nullable = true)
    private String disbursement_mode;

}
