package pieritz.prince.CRMAPP.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "offers")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "angebots_nr", nullable = false, unique = true, length = 50)
    private Long angebotsNr;

    @Column(name = "kontakt_id", nullable = false)
    private Long kontaktId;

    @Column(name = "angebotsdatum")
    @Temporal(TemporalType.DATE)
    private Date angebotsdatum;

    @Column(name = "bruttobetrag")
    private double bruttobetrag;

    @Column(name = "leistungsbezeichnung", length = 100)
    private String leistungsbezeichnung;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "annahmefrist")
    @Temporal(TemporalType.DATE)
    private Date annahmefrist;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "angebot_id")
    private List<Invoice> rechnungen;

    // Getter und Setter
}

