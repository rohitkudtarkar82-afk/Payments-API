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
public class Media {
    public static Media media;

    @Id
    @Column(nullable = true)
    private String type;

    @Column(nullable = true)
    private String binaryEncoding;

}
