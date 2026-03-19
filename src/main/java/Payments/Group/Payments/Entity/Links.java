package Payments.Group.Payments.Entity;

import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Links")
@NoArgsConstructor
@AllArgsConstructor
public class Links {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "href")
    private String href;

    @Column(name = "rel")
    private String rel;

    @Column(name = "method")
    private String method;

    @Column(name = "title")
    private String title;

    @Column(name = "mediaType")
    private String mediaType;

    @Column(name = "encType")
    private String encType;

    @ManyToOne
    @JoinColumn(name = "schema_id")
    private Schema schema;

    @ManyToOne
    @JoinColumn(name = "target_Schema_id")
    private Target_Schema target_Schema;
}
