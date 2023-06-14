package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
public class ContactController {
    private final ContactService contactService;
    private static final Logger logger = LoggerFactory.getLogger(ContactController.class);

    @PostMapping
    public ResponseEntity<ContactResponse> createContact(@RequestBody ContactRequest request) {
        logger.info("Received request to create a contact: {}", request);
        ContactResponse response = contactService.createContact(request);
        logger.info("Created contact: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ContactResponse> getContact(@PathVariable Long id) {
        logger.info("Received request to get contact with ID: {}", id);
        ContactResponse response = contactService.getContactById(id);
        logger.info("Retrieved contact: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ContactResponse>> getAllContacts() {
        logger.info("Received request to get all contacts");
        List<ContactResponse> responses = contactService.getAllContacts();
        logger.info("Retrieved {} contacts", responses.size());
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ContactResponse> updateContact(@PathVariable Long id, @RequestBody ContactRequest request) {
        logger.info("Received request to update contact with ID {}: {}", id, request);
        ContactResponse response = contactService.updateContact(id, request);
        logger.info("Updated contact: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        logger.info("Received request to delete contact with ID: {}", id);
        contactService.deleteContact(id);
        logger.info("Deleted contact with ID: {}", id);
        return ResponseEntity.noContent().build();
    }
}
