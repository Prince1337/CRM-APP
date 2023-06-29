package pieritz.prince.CRMAPP.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
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
    @Size(max = 50, message = "Vorname darf maximal 50 Zeichen lang sein.")
    private String vorname;

    @NotBlank(message = "Name darf nicht leer sein.")
    @Size(max = 50, message = "Name darf maximal 50 Zeichen lang sein.")
    private String name;

    @Size(max = 100, message = "Firma darf maximal 100 Zeichen lang sein.")
    private String firma;

    @NotBlank(message = "E-Mail darf nicht leer sein.")
    @Email(message = "E-Mail ist ungültig.")
    @Size(max = 100, message = "E-Mail darf maximal 100 Zeichen lang sein.")
    private String email;

    @NotBlank(message = "Straße darf nicht leer sein.")
    @Size(max = 100, message = "Straße darf maximal 100 Zeichen lang sein.")
    private String strasse;

    @NotBlank(message = "PLZ darf nicht leer sein.")
    @Size(max = 10, message = "PLZ darf maximal 10 Zeichen lang sein.")
    private String plz;

    @NotBlank(message = "Stadt darf nicht leer sein.")
    @Size(max = 100, message = "Stadt darf maximal 100 Zeichen lang sein.")
    private String stadt;

    @Size(max = 100, message = "Branche darf maximal 100 Zeichen lang sein.")
    private String branche;

    @NotBlank(message = "Anrede darf nicht leer sein.")
    @Size(max = 10, message = "Anrede darf maximal 10 Zeichen lang sein.")
    private String anrede;

    @Size(max = 100, message = "Position darf maximal 100 Zeichen lang sein.")
    private String position;

    @Size(max = 100, message = "Webseite darf maximal 100 Zeichen lang sein.")
    private String webseite;

    @Size(max = 20, message = "Telefon darf maximal 20 Zeichen lang sein.")
    private String telefon;

    @Size(max = 20, message = "Mobil darf maximal 20 Zeichen lang sein.")
    private String mobil;

    private Date geburtsdatum;

    @Size(max = 11, message = "BIC darf maximal 11 Zeichen lang sein.")
    private String bic;

    @NotBlank(message = "IBAN darf nicht leer sein.")
    @Size(max = 34, message = "IBAN darf maximal 34 Zeichen lang sein.")
    private String iban;

    @Size(max = 100, message = "Kategorie darf maximal 100 Zeichen lang sein.")
    private String kategorie;

    @Size(max = 1000, message = "Notizen darf maximal 1000 Zeichen lang sein.")
    private String notizen;
}
