package pieritz.prince.CRMAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SettingsRequest {
    private String meinUnternehmen;
    private String ansprechpartner;
    private String strasse;
    private String plz;
    private String stadt;
    private String telefon;
    private String mail;
    private String webseite;
    private String ustIdNr;
    private String iban;
    private String bic;
    private String synchronisierung;
    private Integer annahmefristAngebote;
    private boolean angebotSenden;
    private boolean rechnungSenden;
    private String kontaktkategorien;
}
