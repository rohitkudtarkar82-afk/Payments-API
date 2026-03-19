package Payments.Group.Payments.Entity;

import java.util.UUID;

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
@Table(name = "Exchange_Rate")
@NoArgsConstructor
@AllArgsConstructor
public class Exchange_Rate {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "source_currency")
    private String source_currency;

    @Column(name = "target_currency")
    private String target_currency;

    @Column(name = "value")
    private String value;

}
