package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.dto.OfferRequest;
import pieritz.prince.CRMAPP.dto.OfferResponse;

import java.util.List;

public interface OfferService {
    OfferResponse createOffer(OfferRequest request);
    OfferResponse getOfferById(Long id);
    Page<OfferResponse> getAllOffers(Pageable pageable);
    OfferResponse updateOffer(Long id, OfferRequest request);
    void deleteOffer(Long id);
    Page<OfferResponse> getOffersByContactId(Long contactId, Pageable pageable);
    long countByStatus(String status);
    Page<OfferResponse> getOffersByDescription(String description, Pageable pageable);

}
