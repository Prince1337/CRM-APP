package pieritz.prince.CRMAPP.web;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.ContactRequest;
import pieritz.prince.CRMAPP.dto.ContactResponse;
import pieritz.prince.CRMAPP.services.interfaces.ContactService;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
@Slf4j
public class ContactController {
    private final ContactService contactService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ContactResponse> createContact(@RequestBody @Valid ContactRequest request) {
        log.info("Received request to create a contact: {}", request);
        ContactResponse response = contactService.createContact(request);
        log.info("Created contact: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactResponse> getContact(@PathVariable Long id) {
        log.info("Received request to get contact with ID: {}", id);
        ContactResponse response = contactService.getContactById(id);
        log.info("Retrieved contact: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<Page<ContactResponse>> getAllContacts(Pageable pageable) {
        log.info("Received request to get all contacts");
        Page<ContactResponse> response = contactService.getAllContacts(pageable);
        log.info("Retrieved {} contacts", response.getTotalElements());
        return ResponseEntity.ok(response);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ContactResponse> updateContact(@PathVariable Long id, @RequestBody ContactRequest request) {
        log.info("Received request to update contact with ID {}: {}", id, request);
        ContactResponse response = contactService.updateContact(id, request);
        log.info("Updated contact: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        log.info("Received request to delete contact with ID: {}", id);
        contactService.deleteContact(id);
        log.info("Deleted contact with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
