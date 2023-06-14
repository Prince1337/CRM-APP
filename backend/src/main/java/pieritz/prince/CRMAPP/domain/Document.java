package pieritz.prince.CRMAPP.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "art", nullable = false, length = 50)
    private String art;

    @Column(name = "kontakt_id", nullable = false)
    private Long kontaktId;

    @Column(name = "speicherdatum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date speicherdatum;

    @Column(name = "dateityp", length = 50)
    private String dateityp;

    @Column(name = "dateigroesse")
    private long dateigroesse;

    @Column(name = "pfad", length = 255)
    private String pfad;

    @Column(name = "notizen", length = 1000)
    private String notizen;

    @Column(name = "erstellt_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date erstelltDatum;

    @Column(name = "geaendert_datum")
    @Temporal(TemporalType.TIMESTAMP)
    private Date geaendertDatum;

    // Getter und Setter
}

