package pieritz.prince.CRMAPP.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.*;

@Getter
@RequiredArgsConstructor
@Builder
public class ProductRequest {
    @NotBlank(message = "Die Bezeichnung darf nicht leer sein")
    private final String bezeichnung;

    @Positive(message = "Der Nettopreis muss positiv sein")
    private final double nettopreis;

    @PositiveOrZero(message = "Die Umsatzsteuer darf nicht negativ sein")
    private final double umst;

    @NotBlank(message = "Die Gruppe darf nicht leer sein")
    private final String gruppe;

    private final String status;
    private final String notizen;
}

