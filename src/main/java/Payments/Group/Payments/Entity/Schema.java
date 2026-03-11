package Payments.Group.Payments.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "json_schema")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Schema {

    @Id
    @Column(nullable = true)
    private String additionalItems;

    @Column(nullable = true)
    private String items;

    @Column(nullable = true)
    private String definitions;

    @Column(nullable = true)
    private String patternProperties;

    @Column(nullable = true)
    private String properties;

    @Column(nullable = true)
    private String allOf;

    @Column(nullable = true)
    private String anyOf;

    @Column(nullable = true)
    private String oneOf;

    @Column(nullable = true)
    private String notValue;

    @Column(nullable = true)
    private String link1;

    @Column(nullable = true)
    private String fragmentResolution;

    @Column(nullable = true)
    private String pathStart;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "media_id")
    private Media media;

    @OneToMany(mappedBy = "schema", cascade = CascadeType.ALL)
    private List<Link> link;

}
