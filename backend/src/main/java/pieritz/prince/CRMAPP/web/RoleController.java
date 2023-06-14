package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    private static final Logger logger = LoggerFactory.getLogger(RoleController.class);

    private final AuthenticationService authenticationService;

    @GetMapping("/getUserRole")
    public ResponseEntity<RoleResponse> getUserRole() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        logger.info("getUserRole request received. User: {}", authentication.getName());

        ResponseEntity<RoleResponse> response = ResponseEntity.ok(authenticationService.getRole(authentication));

        logger.info("getUserRole response: {}", response);

        return response;
    }
}
