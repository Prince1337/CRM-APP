package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.DocumentRequest;
import pieritz.prince.CRMAPP.dto.DocumentResponse;
import pieritz.prince.CRMAPP.services.interfaces.DocumentService;

import java.util.List;

@RestController
@RequestMapping("/documents")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class DocumentController {
    private final DocumentService documentService;
    private static final Logger logger = LoggerFactory.getLogger(DocumentController.class);

    @PostMapping
    public ResponseEntity<DocumentResponse> createDocument(@RequestBody DocumentRequest request) {
        logger.info("Received request to create a document: {}", request);
        DocumentResponse response = documentService.createDocument(request);
        logger.info("Created document: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DocumentResponse> getDocument(@PathVariable Long id) {
        logger.info("Received request to get document with ID: {}", id);
        DocumentResponse response = documentService.getDocumentById(id);
        logger.info("Retrieved document: {}", response);
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<DocumentResponse>> getAllDocuments() {
        logger.info("Received request to get all documents");
        List<DocumentResponse> responses = documentService.getAllDocuments();
        logger.info("Retrieved all documents: {}", responses);
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DocumentResponse> updateDocument(@PathVariable Long id, @RequestBody DocumentRequest request) {
        logger.info("Received request to update document with ID {}: {}", id, request);
        DocumentResponse response = documentService.updateDocument(id, request);
        logger.info("Updated document: {}", response);
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDocument(@PathVariable Long id) {
        logger.info("Received request to delete document with ID: {}", id);
        documentService.deleteDocument(id);
        logger.info("Document deleted successfully");
        return ResponseEntity.noContent().build();
    }
}
