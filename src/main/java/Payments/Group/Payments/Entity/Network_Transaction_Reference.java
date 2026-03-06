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
public class Network_Transaction_Reference {
    public static Network_Transaction_Reference network_Transaction_Reference;
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = true)
    private String date;

    @Column(nullable = true)
    private String network;

    @Column(nullable = true)
    private String acquirer_reference_number;

}
