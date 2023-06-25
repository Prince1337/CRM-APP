package pieritz.prince.CRMAPP.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "contacts")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "vorname", nullable = false, length = 50)
    private String vorname;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "firma", length = 100)
    private String firma;

    @Column(name = "email", nullable = false, length = 100, unique = true)
    private String email;

    @Column(name = "ort", length = 100)
    private String ort;

    @Column(name = "gespeichert_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date gespeichertDatum;

    @Column(name = "strasse", length = 100)
    private String strasse;

    @Column(name = "plz", length = 10)
    private String plz;

    @Column(name = "stadt", length = 100)
    private String stadt;

    @Column(name = "branche", length = 100)
    private String branche;

    @Column(name = "anrede", length = 10)
    private String anrede;

    @Column(name = "position", length = 100)
    private String position;

    @Column(name = "webseite", length = 100)
    private String webseite;

    @Column(name = "telefon", length = 20)
    private String telefon;

    @Column(name = "mobil", length = 20)
    private String mobil;

    @Column(name = "geburtsdatum")
    @Temporal(TemporalType.DATE)
    private Date geburtsdatum;

    @Column(name = "bic", length = 11)
    private String bic;

    @Column(name = "iban", length = 34)
    private String iban;

    @Column(name = "kategorie", length = 100)
    private String kategorie;

    @Column(name = "notizen", length = 1000)
    private String notizen;

    @Column(name = "geaendert_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date geaendertDatum;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kontakt_id")
    private List<Document> dokumenten;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kontakt_id")
    private List<Task> aufgaben;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @Column(name = "angeboten")
    @JoinColumn(name = "kontakt_id")
    private List<Offer> angebote;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "kontakt_id")
    private List<Invoice> rechnungen;

    // Getter und Setter
}

