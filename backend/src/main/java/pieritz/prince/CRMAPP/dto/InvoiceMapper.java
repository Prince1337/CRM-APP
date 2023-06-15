package pieritz.prince.CRMAPP.dto;

import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Invoice;

import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    private final ProductMapper productMapper = new ProductMapper();
    public InvoiceMapper() {
    }

    public Invoice toInvoice(InvoiceRequest request) {
        return Invoice.builder()
                .kontaktId(request.getKontaktId())
                .rechnungsdatum(request.getRechnungsdatum())
                .bruttobetrag(request.getBruttobetrag())
                .leistungsbezeichnung(request.getLeistungsbezeichnung())
                .status(request.getStatus())
                .zahlungsfrist(request.getZahlungsfrist())
                .produkte(request.getProdukte().stream().map(productMapper::toProduct).collect(Collectors.toList()))
                .build();
    }

    public InvoiceResponse toInvoiceResponse(Invoice invoice) {
        return InvoiceResponse.builder()
                .rechnungsnummer(invoice.getRechnungsnummer())
                .kontaktId(invoice.getKontaktId())
                .rechnungsdatum(invoice.getRechnungsdatum())
                .bruttobetrag(invoice.getBruttobetrag())
                .leistungsbezeichnung(invoice.getLeistungsbezeichnung())
                .status(invoice.getStatus())
                .zahlungsfrist(invoice.getZahlungsfrist())
                .produkte(invoice.getProdukte().stream().map(productMapper::toProductResponse).collect(Collectors.toList()))
                .build();
    }

    public void updateInvoiceFromRequest(InvoiceRequest request, Invoice invoice) {
        invoice.setKontaktId(request.getKontaktId());
        invoice.setRechnungsdatum(request.getRechnungsdatum());
        invoice.setBruttobetrag(request.getBruttobetrag());
        invoice.setLeistungsbezeichnung(request.getLeistungsbezeichnung());
        invoice.setStatus(request.getStatus());
        invoice.setZahlungsfrist(request.getZahlungsfrist());
    }
}