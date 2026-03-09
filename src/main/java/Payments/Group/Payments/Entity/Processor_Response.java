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
public class Processor_Response {

    @Id
    @Column(nullable = true)
    private String avs_code;

    @Column(nullable = true)
    private String cvv_code;

    @Column(nullable = true)
    private String response_code;

    @Column(nullable = true)
    private String payment_advice_code;

}
