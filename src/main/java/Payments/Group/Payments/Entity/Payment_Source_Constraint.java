package Payments.Group.Payments.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Payment_Source_Constraint")
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Source_Constraint {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "constraint_type")
    private String constraint_type;

    @Column(name = "payment_sources")
    private String payment_sources;

     @ManyToOne
@JoinColumn(name = "preferences_id", insertable = false, updatable = false)
private Preferences preferences;

}
