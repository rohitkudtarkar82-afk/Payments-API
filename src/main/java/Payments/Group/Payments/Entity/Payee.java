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
public class Payee {
    public static Payee payee;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID merchant_id;

    @Column(nullable = true)
    private String email_address;

}
