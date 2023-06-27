package pieritz.prince.CRMAPP.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
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
    @NotNull
    private Long angebotsNr;

    @NotNull
    private Long kontaktId;

    @NotNull
    @Past
    private Date angebotsdatum;

    @Positive
    private double bruttobetrag;

    @NotBlank
    @Size(max = 100)
    private String leistungsbezeichnung;

    @NotBlank
    @Size(max = 50)
    private String status;

    @NotNull
    @Future
    private Date annahmefrist;

    @Valid
    private List<InvoiceRequest> rechnungen;
}
