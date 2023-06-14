package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.RegisterRequest;
import pieritz.prince.CRMAPP.dto.UserResponse;
import pieritz.prince.CRMAPP.services.AuthenticationService;
import pieritz.prince.CRMAPP.services.UserDetailsServiceImplementation;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
@CrossOrigin(originPatterns = "http://localhost:4200")
public class UserController {

    private final UserDetailsServiceImplementation userDetailsService;
    private final AuthenticationService authenticationService;

    @GetMapping
    public List<String> getAllUsernames() {
        return userDetailsService.getAllUsernames();
    }

    @GetMapping("/admin/user/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        UserResponse response = userDetailsService.getUser(id);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/admin/user/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable Long id, @RequestBody RegisterRequest updatedUser) {
        return ResponseEntity.ok(authenticationService.updateUser(updatedUser));
    }

    @GetMapping("/admin/users")
    public ResponseEntity<List<UserResponse>> getUser() {
        List<UserResponse> userResponses = userDetailsService.getUsers();
        return ResponseEntity.ok(userResponses);

    }
}

