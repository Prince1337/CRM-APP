package pieritz.prince.CRMAPP.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "bezeichnung", nullable = false, length = 100)
    private String bezeichnung;

    @Column(name = "nettopreis")
    private double nettopreis;

    @Column(name = "umst")
    private double umst;

    @Column(name = "gruppe", length = 50)
    private String gruppe;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "notizen", length = 200)
    private String notizen;

    // Getter und Setter
}

