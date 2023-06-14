package pieritz.prince.CRMAPP.domain;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tasks")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "art", nullable = false, length = 50)
    private String art;

    @Column(name = "bezeichnung", nullable = false, length = 100)
    private String bezeichnung;

    @Column(name = "kontakt_id", nullable = false)
    private Long kontaktId;

    @Column(name = "startdatum")
    @Temporal(TemporalType.DATE)
    private Date startdatum;

    @Column(name = "startzeit")
    @Temporal(TemporalType.TIME)
    private Date startzeit;

    @Column(name = "ort", length = 100)
    private String ort;

    // Getter und Setter
}

