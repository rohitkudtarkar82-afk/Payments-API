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
public class Channel {
    public static Channel channel;
    @Id
    @Column(nullable = true)
    private String browser_type;

    @Column(nullable = true)
    private String client_os;

    @Column(nullable = true)
    private String device_type;

}
