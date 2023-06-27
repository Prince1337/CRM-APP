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
public class InvoiceRequest {
    @NotNull
    private Long kontaktId;

    @NotNull
    @Past
    private Date rechnungsdatum;

    @Min(0)
    private double bruttobetrag;

    @NotBlank
    @Size(max = 100)
    private String leistungsbezeichnung;

    @NotBlank
    @Size(max = 50)
    private String status;

    @NotNull
    @Past
    private Date zahlungsfrist;

    @Valid
    private List<ProductRequest> produkte;

}
