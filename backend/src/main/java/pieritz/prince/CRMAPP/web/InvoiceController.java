package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.InvoiceRequest;
import pieritz.prince.CRMAPP.dto.InvoiceResponse;
import pieritz.prince.CRMAPP.services.interfaces.InvoiceService;

import java.util.List;

@RestController
@RequestMapping("/invoices")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class InvoiceController {
    private static final Logger logger = LoggerFactory.getLogger(InvoiceController.class);
    private final InvoiceService invoiceService;

    @PostMapping
    public ResponseEntity<InvoiceResponse> createInvoice(@RequestBody InvoiceRequest request) {
        logger.info("Received request to create invoice");
        InvoiceResponse response = invoiceService.createInvoice(request);
        logger.info("Invoice created successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceResponse> getInvoice(@PathVariable Long id) {
        logger.info("Received request to get invoice with ID: {}", id);
        InvoiceResponse response = invoiceService.getInvoiceById(id);
        logger.info("Invoice retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<InvoiceResponse>> getAllInvoices(Pageable pageable) {
        logger.info("Received request to get all invoices");
        Page<InvoiceResponse> responses = invoiceService.getAllInvoices(pageable);
        logger.info("Invoices retrieved successfully");
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<InvoiceResponse> updateInvoice(@PathVariable Long id, @RequestBody InvoiceRequest request) {
        logger.info("Received request to update invoice with ID: {}", id);
        InvoiceResponse response = invoiceService.updateInvoice(id, request);
        logger.info("Invoice updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        logger.info("Received request to delete invoice with ID: {}", id);
        invoiceService.deleteInvoice(id);
        logger.info("Invoice deleted successfully");
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/byContact")
    public ResponseEntity<Page<InvoiceResponse>> getInvoicesByContactId(@RequestParam Long contactId, Pageable pageable) {
        Page<InvoiceResponse> responses = invoiceService.getInvoicesByContactId(contactId, pageable);
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/countByStatus")
    public long countInvoicesByStatus(@RequestParam String status) {
        return invoiceService.countByStatus(status);
    }

    @GetMapping("/byDescription")
    public ResponseEntity<Page<InvoiceResponse>> getInvoicesByDescription(@RequestParam String description, Pageable pageable) {
        Page<InvoiceResponse> responses = invoiceService.getInvoicesByDescription(description, pageable);
        return ResponseEntity.ok(responses);
    }
}
