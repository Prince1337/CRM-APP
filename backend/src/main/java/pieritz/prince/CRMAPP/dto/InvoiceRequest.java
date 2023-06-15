package pieritz.prince.CRMAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InvoiceRequest {
    private Long kontaktId;
    private Date rechnungsdatum;
    private double bruttobetrag;
    private String leistungsbezeichnung;
    private String status;
    private Date zahlungsfrist;
    private List<ProductRequest> produkte;

}
