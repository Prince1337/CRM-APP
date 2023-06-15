package pieritz.prince.CRMAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DocumentResponse {
    private Long id;
    private String art;
    private Long kontaktId;
    private Date speicherdatum;
    private String dateityp;
    private long dateigroesse;
    private String pfad;
    private String notizen;
    private Date erstelltDatum;
    private Date geaendertDatum;
}
