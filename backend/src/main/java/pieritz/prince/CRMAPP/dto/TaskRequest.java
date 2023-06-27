package pieritz.prince.CRMAPP.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
    @NotBlank
    @Size(max = 50)
    private String art;

    @NotBlank
    @Size(max = 100)
    private String bezeichnung;

    @NotNull
    private Long kontaktId;

    @NotNull
    private Date startdatum;

    @NotNull
    private Date startzeit;

    @Size(max = 100)
    private String ort;
}
