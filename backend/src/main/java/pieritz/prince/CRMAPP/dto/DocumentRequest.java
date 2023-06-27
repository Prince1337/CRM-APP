package pieritz.prince.CRMAPP.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentRequest {
    @NotBlank(message = "Die Art darf nicht leer sein")
    private String art;

    @NotNull(message = "Die Kontakt-ID darf nicht null sein")
    private Long kontaktId;

    @NotNull(message = "Das Speicherdatum darf nicht null sein")
    @PastOrPresent(message = "Das Speicherdatum muss in der Vergangenheit oder in der Gegenwart liegen")
    private Date speicherdatum;

    @NotBlank(message = "Der Dateityp darf nicht leer sein")
    private String dateityp;

    @Min(value = 0, message = "Die Dateigröße muss größer oder gleich 0 sein")
    private long dateigroesse;

    @NotBlank(message = "Der Pfad darf nicht leer sein")
    private String pfad;

    private String notizen;

    @NotNull(message = "Das Erstelldatum darf nicht null sein")
    private Date erstelltDatum;

    @NotNull(message = "Das Geändert-Datum darf nicht null sein")
    private Date geaendertDatum;
}
