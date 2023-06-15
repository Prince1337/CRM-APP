package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pieritz.prince.CRMAPP.domain.Invoice;
import pieritz.prince.CRMAPP.domain.Offer;
import pieritz.prince.CRMAPP.domain.Product;
import pieritz.prince.CRMAPP.dto.*;
import pieritz.prince.CRMAPP.repositories.OfferRepository;
import pieritz.prince.CRMAPP.services.interfaces.OfferService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class OfferServiceImplementation implements OfferService {
    private final OfferRepository offerRepository;
    private final OfferMapper offerMapper = new OfferMapper();

    @Override
    public OfferResponse createOffer(OfferRequest request) {
        Offer offer = offerMapper.toOffer(request);
        offer = offerRepository.save(offer);
        return offerMapper.toOfferResponse(offer);
    }

    @Override
    public OfferResponse getOfferById(Long id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
        return offerMapper.toOfferResponse(offer);
    }

    @Override
    public List<OfferResponse> getAllOffers() {
        List<Offer> offers = offerRepository.findAll();
        return offers.stream()
                .map(offerMapper::toOfferResponse)
                .collect(Collectors.toList());
    }

    @Override
    public OfferResponse updateOffer(Long id, OfferRequest request) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));

        offerMapper.updateOfferFromRequest(request, offer);
        offer = offerRepository.save(offer);
        return offerMapper.toOfferResponse(offer);
    }

    @Override
    public void deleteOffer(Long id) {
        Offer offer = offerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Offer not found"));
        offerRepository.delete(offer);
    }
}

