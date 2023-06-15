package pieritz.prince.CRMAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {
    private String bezeichnung;
    private double nettopreis;
    private double umst;
    private String gruppe;
    private String status;
    private String notizen;
}
