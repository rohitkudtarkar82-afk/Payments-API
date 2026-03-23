package Payments.Group.Payments.Entity;

import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;

import jakarta.persistence.OneToOne;
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


    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "schema_id", referencedColumnName = "id")
    private Schema schema;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "target_schema_id", referencedColumnName = "id")
    private Target_Schema target_Schema;
}
