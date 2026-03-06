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
public class Phone {
    public static Phone phone;
    @Id
    @Column(nullable = true)
    private String country_code;

    @Column(nullable = true)
    private String national_number;

    @Column(nullable = true)
    private String extension_number;

    
}
