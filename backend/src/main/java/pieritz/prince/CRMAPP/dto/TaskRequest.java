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
public class TaskRequest {
    private String art;
    private String bezeichnung;
    private Long kontaktId;
    private Date startdatum;
    private Date startzeit;
    private String ort;
}
