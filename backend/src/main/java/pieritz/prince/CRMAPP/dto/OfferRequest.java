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
public class OfferRequest {
    private Long angebotsNr;
    private Long kontaktId;
    private Date angebotsdatum;
    private double bruttobetrag;
    private String leistungsbezeichnung;
    private String status;
    private Date annahmefrist;
    private List<InvoiceRequest> rechnungen;
}
