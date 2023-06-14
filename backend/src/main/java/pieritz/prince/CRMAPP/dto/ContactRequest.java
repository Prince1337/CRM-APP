package pieritz.prince.CRMAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ContactRequest {
    private String vorname;
    private String name;
    private String firma;
    private String email;
    private String ort;
    private Date gespeichertDatum;
    private String strasse;
    private String plz;
    private String stadt;
    private String branche;
    private String anrede;
    private String position;
    private String webseite;
    private String telefon;
    private String mobil;
    private Date geburtsdatum;
    private String bic;
    private String iban;
    private String kategorie;
    private String notizen;
}
