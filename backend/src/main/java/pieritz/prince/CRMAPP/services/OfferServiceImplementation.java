package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
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
    public Page<OfferResponse> getAllOffers(Pageable pageable) {
        Page<Offer> offers = offerRepository.findAll(pageable);
        List<OfferResponse> offerResponses = offers.getContent().stream()
                .map(offerMapper::toOfferResponse)
                .collect(Collectors.toList());
        return new PageImpl<>(offerResponses, pageable, offers.getTotalElements());
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

