package pieritz.prince.CRMAPP.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String password;
    private Set<String> roles;


}