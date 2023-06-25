package pieritz.prince.CRMAPP.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ContactResponse {
    private Long id;
    private String vorname;
    private String name;
    private String firma;
    private String ort;
    private Date gespeichertDatum;
    private String strasse;
    private String plz;
    private String stadt;
    private String branche;
    private String anrede;
    private String position;
    private String webseite;
    private Date geburtsdatum;
    private String kategorie;
    private String notizen;
}

