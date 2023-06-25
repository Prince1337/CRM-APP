package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.OfferRequest;
import pieritz.prince.CRMAPP.dto.OfferResponse;
import pieritz.prince.CRMAPP.services.interfaces.OfferService;

import java.util.List;

@RestController
@RequestMapping("/offers")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class OfferController {
    private static final Logger logger = LoggerFactory.getLogger(OfferController.class);
    private final OfferService offerService;

    @PostMapping
    public ResponseEntity<OfferResponse> createOffer(@RequestBody OfferRequest request) {
        logger.info("Received request to create offer");
        OfferResponse response = offerService.createOffer(request);
        logger.info("Offer created successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<OfferResponse> getOffer(@PathVariable Long id) {
        logger.info("Received request to get offer with ID: {}", id);
        OfferResponse response = offerService.getOfferById(id);
        logger.info("Offer retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<Page<OfferResponse>> getAllOffers(Pageable pageable) {
        logger.info("Received request to get all offers");
        Page<OfferResponse> responses = offerService.getAllOffers(pageable);
        logger.info("Offers retrieved successfully");
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OfferResponse> updateOffer(@PathVariable Long id, @RequestBody OfferRequest request) {
        logger.info("Received request to update offer with ID: {}", id);
        OfferResponse response = offerService.updateOffer(id, request);
        logger.info("Offer updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOffer(@PathVariable Long id) {
        logger.info("Received request to delete offer with ID: {}", id);
        offerService.deleteOffer(id);
        logger.info("Offer deleted successfully");
        return ResponseEntity.noContent().build();
    }
}
