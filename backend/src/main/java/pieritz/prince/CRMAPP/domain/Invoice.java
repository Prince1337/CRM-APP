package pieritz.prince.CRMAPP.domain;

import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "rechnungsnummer")
    private Long rechnungsnummer;

    @Column(name = "kontakt_id", nullable = false)
    private Long kontaktId;

    @Column(name = "rechnungsdatum")
    @Temporal(TemporalType.DATE)
    private Date rechnungsdatum;

    @Column(name = "bruttobetrag")
    private double bruttobetrag;

    @Column(name = "leistungsbezeichnung", length = 100)
    private String leistungsbezeichnung;

    @Column(name = "status", length = 50)
    private String status;

    @Column(name = "zahlungsfrist")
    @Temporal(TemporalType.DATE)
    private Date zahlungsfrist;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "rechnungsnummer")
    private List<Product> produkte;

}

