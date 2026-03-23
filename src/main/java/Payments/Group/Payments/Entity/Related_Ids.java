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
@Table(name = "Related_Ids")
@NoArgsConstructor
@AllArgsConstructor
public class Related_Ids {

   @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "order_id")
    private UUID order_id;

    @Column(name = "authorization_id")
    private UUID authorization_id;

    @Column(name = "capture_id")
    private UUID capture_id;

}
