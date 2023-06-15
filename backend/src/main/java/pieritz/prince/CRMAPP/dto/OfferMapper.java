package pieritz.prince.CRMAPP.dto;

import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Offer;

import java.util.Date;
import java.util.stream.Collectors;

@Component
public class OfferMapper {

    private final InvoiceMapper invoiceMapper = new InvoiceMapper();

    public OfferResponse toOfferResponse(Offer offer) {
        return OfferResponse.builder()
                .angebotsNr(offer.getAngebotsNr())
                .kontaktId(offer.getKontaktId())
                .angebotsdatum(offer.getAngebotsdatum())
                .bruttobetrag(offer.getBruttobetrag())
                .leistungsbezeichnung(offer.getLeistungsbezeichnung())
                .status(offer.getStatus())
                .annahmefrist(offer.getAnnahmefrist())
                .rechnungen(offer.getRechnungen().stream().map(invoiceMapper::toInvoiceResponse).collect(Collectors.toList()))
                .build();
    }

    public Offer toOffer(OfferRequest request) {
        return Offer.builder()
                .angebotsNr(request.getAngebotsNr())
                .kontaktId(request.getKontaktId())
                .angebotsdatum(new Date())
                .bruttobetrag(request.getBruttobetrag())
                .leistungsbezeichnung(request.getLeistungsbezeichnung())
                .status(request.getStatus())
                .annahmefrist(request.getAnnahmefrist())
                .rechnungen(request.getRechnungen().stream().map(invoiceMapper::toInvoice).collect(Collectors.toList()))
                .build();
    }

    public void updateOfferFromRequest(OfferRequest request, Offer offer) {
        offer.setAngebotsdatum(request.getAngebotsdatum());
        offer.setBruttobetrag(request.getBruttobetrag());
        offer.setLeistungsbezeichnung(request.getLeistungsbezeichnung());
        offer.setStatus(request.getStatus());
        offer.setAnnahmefrist(request.getAnnahmefrist());
        offer.setRechnungen(request.getRechnungen().stream().map(invoiceMapper::toInvoice).collect(Collectors.toList()));
    }
}