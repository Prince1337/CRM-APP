package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pieritz.prince.CRMAPP.dto.RoleResponse;
import pieritz.prince.CRMAPP.services.AuthenticationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/role")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class RoleController {


    private final AuthenticationService authenticationService;

    @GetMapping("/getUserRole")
    public ResponseEntity<RoleResponse> getUserRole() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        return ResponseEntity.ok(authenticationService.getRole(authentication));
    }

}
