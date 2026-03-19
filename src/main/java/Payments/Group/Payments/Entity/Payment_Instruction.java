package Payments.Group.Payments.Entity;

import java.util.List;
import java.util.UUID;

import Payments.Group.Payments.DTO.Platform_FeesRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Payment_Instruction")
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Instruction {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "payee_pricing_tier_id")
    private String payee_pricing_tier_id;

    @Column(name = "payee_receivable_fx_rate_id")
    private String payee_receivable_fx_rate_id;

    @Column(name = "disbursement_mode")
    private String disbursement_mode;

    public List<Platform_FeesRequestDTO> getPlatform_Fees() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlatform_Fees'");
    }

}
