package Payments.Group.Payments.Entity;

import java.util.List;
import java.util.UUID;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "schema_table")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schema {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    @Column(name = "additionalItems")
    private String additionalItems;

    @Column(name = "items")
    private String items;

    @Column(name = "definitions")
    private String definitions;

    @Column(name = "patternProperties")
    private String patternProperties;

    @Column(name = "properties")
    private String properties;

    @Column(name = "allOf")
    private String allOf;

    @Column(name = "anyOf")
    private String anyOf;

    @Column(name = "oneOf")
    private String oneOf;

    @Column(name = "notValue")
    private String notValue;

    @Column(name = "links1")
    private String links1;

    @Column(name = "fragmentResolution")
    private String fragmentResolution;

    @Column(name = "pathStart")
    private String pathStart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "media_id")
    private Media media;

    @OneToMany(mappedBy = "schema", cascade = CascadeType.ALL)
    private List<Links> links;

}
