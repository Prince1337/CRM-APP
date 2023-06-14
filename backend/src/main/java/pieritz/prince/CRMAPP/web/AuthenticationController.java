package pieritz.prince.CRMAPP.web;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.domain.User;
import pieritz.prince.CRMAPP.dto.AuthenticationRequest;
import pieritz.prince.CRMAPP.dto.AuthenticationResponse;
import pieritz.prince.CRMAPP.dto.RegisterRequest;
import pieritz.prince.CRMAPP.services.AuthenticationService;

import java.io.IOException;

@RestController
@CrossOrigin("http://localhost:4200")
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {
    private static final Logger logger = LoggerFactory.getLogger(AuthenticationController.class);

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody RegisterRequest request,
            HttpServletRequest servletRequest
    ) {
        logger.info("Register request received. Body: {}", request);
        logger.info("Remote Address: {}", servletRequest.getRemoteAddr());

        ResponseEntity<AuthenticationResponse> response = ResponseEntity.ok(authenticationService.register(request));
        logger.info("Register response: {}", response);

        return response;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request,
            HttpServletRequest servletRequest
    ) {
        logger.info("Authenticate request received. Body: {}", request);
        logger.info("Remote Address: {}", servletRequest.getRemoteAddr());

        ResponseEntity<AuthenticationResponse> response = ResponseEntity.ok(authenticationService.authenticate(request));
        logger.info("Authenticate response: {}", response);

        return response;
    }

    @PostMapping("/logout")
    public HttpServletResponse logout(HttpServletRequest request, HttpServletResponse response) {
        String authHeader = request.getHeader("Authorization");
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            return response;
        } else {
            return null;
        }
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody RegisterRequest request) {
        User user = authenticationService.updateUser(id, request);
        return ResponseEntity.ok(user);
    }

    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }
}
