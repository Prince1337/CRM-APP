package pieritz.prince.CRMAPP.services.interfaces;

import pieritz.prince.CRMAPP.dto.OfferRequest;
import pieritz.prince.CRMAPP.dto.OfferResponse;

import java.util.List;

public interface OfferService {
    OfferResponse createOffer(OfferRequest request);
    OfferResponse getOfferById(Long id);
    List<OfferResponse> getAllOffers();
    OfferResponse updateOffer(Long id, OfferRequest request);
    void deleteOffer(Long id);
}
