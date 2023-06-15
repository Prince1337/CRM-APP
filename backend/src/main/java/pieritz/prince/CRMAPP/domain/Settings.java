package pieritz.prince.CRMAPP.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "einstellungen")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Settings {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "mein_unternehmen", nullable = false, length = 100)
    private String meinUnternehmen;

    @Column(name = "ansprechpartner", length = 100)
    private String ansprechpartner;

    @Column(name = "strasse", length = 100)
    private String strasse;

    @Column(name = "plz", length = 10)
    private String plz;

    @Column(name = "stadt", length = 100)
    private String stadt;

    @Column(name = "telefon", length = 50)
    private String telefon;

    @Column(name = "mail", length = 100)
    private String mail;

    @Column(name = "webseite", length = 100)
    private String webseite;

    @Column(name = "ust_id_nr", length = 50)
    private String ustIdNr;

    @Column(name = "iban", length = 50)
    private String iban;

    @Column(name = "bic", length = 50)
    private String bic;

    @Column(name = "synchronisierung", length = 50)
    private String synchronisierung;

    @Column(name = "annahmefrist_angebote")
    private Integer annahmefristAngebote;

    @Column(name = "angebot_senden")
    private boolean angebotSenden;

    @Column(name = "rechnung_senden")
    private boolean rechnungSenden;

    @Column(name = "kontaktkategorien", length = 200)
    private String kontaktkategorien;

    // Getter und Setter
}

