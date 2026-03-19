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
@Table(name = "Processor_Response")
@NoArgsConstructor
@AllArgsConstructor
public class Processor_Response {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "avs_code")
    private String avs_code;

    @Column(name = "cvv_code")
    private String cvv_code;

    @Column(name = "response_code")
    private String response_code;

    @Column(name = "payment_advice_code")
    private String payment_advice_code;

}
