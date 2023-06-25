package pieritz.prince.CRMAPP.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
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

    @NotBlank(message = "Vorname darf nicht leer sein.")
    private String vorname;

    @NotBlank(message = "Name darf nicht leer sein.")
    private String name;

    private String firma;

    @NotBlank(message = "E-Mail darf nicht leer sein.")
    @Email(message = "E-Mail ist ungültig.")
    private String email;

    @NotBlank(message = "Ort darf nicht leer sein.")
    private String ort;

    private Date gespeichertDatum;

    @NotBlank(message = "Straße darf nicht leer sein.")
    private String strasse;

    @NotBlank(message = "PLZ darf nicht leer sein.")
    private String plz;

    @NotBlank(message = "Stadt darf nicht leer sein.")
    private String stadt;

    private String branche;

    @NotBlank(message = "Anrede darf nicht leer sein.")
    private String anrede;

    private String position;

    private String webseite;

    private String telefon;

    private String mobil;

    private Date geburtsdatum;

    private String bic;

    @NotBlank(message = "IBAN darf nicht leer sein.")
    private String iban;

    private String kategorie;

    private String notizen;
}
