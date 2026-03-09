package Payments.Group.Payments.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment_Source_Constraint {

    @Id
    @Column(nullable = true)
    private String constraint_type;

    @Column(nullable = true)
    private String payment_sources;

    @ManyToOne
    @JoinColumn(name = "preferences_id")
    private Preferences preferences;

}
