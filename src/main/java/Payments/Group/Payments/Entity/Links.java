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
public class Links {
    public static Links links;
    @Id
    @Column(nullable = true)
    private String href;

    @Column(nullable = true)
    private String rel;

    @Column(nullable = true)
    private String method;

    @Column(nullable = true)
    private String title;

    @Column(nullable = true)
    private String mediaType;

    @Column(nullable = true)
    private String encType;

    @ManyToOne
    @JoinColumn(name = "schema_id")
    private Schema schema;

    @ManyToOne
    @JoinColumn(name = "target_Schema_id")
    private Target_Schema target_Schema;
}
