package pieritz.prince.CRMAPP.dto;

import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Invoice;
import pieritz.prince.CRMAPP.domain.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class InvoiceMapper {

    private final ProductMapper productMapper = new ProductMapper();
    public InvoiceMapper() {
    }

    public Invoice toInvoice(InvoiceRequest request) {
        List<Product> produkte = request.getProdukte().stream().map(productMapper::toProduct).toList();
        double bruttoBetrag = produkte.stream().mapToDouble(Product::getNettopreis).sum();

        return Invoice.builder()
            .kontaktId(request.getKontaktId())
            .rechnungsdatum(request.getRechnungsdatum())
            .bruttobetrag(bruttoBetrag)
            .leistungsbezeichnung(request.getLeistungsbezeichnung())
            .status(request.getStatus())
            .zahlungsfrist(request.getZahlungsfrist())
            .produkte(produkte)
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
                .produkte(invoice.getProdukte().stream().map(productMapper::toProductResponse).toList())
                .build();
    }

    public void updateInvoiceFromRequest(InvoiceRequest request, Invoice invoice) {
        List<Product> produkte = request.getProdukte().stream().map(productMapper::toProduct).toList();
        double bruttoBetrag = produkte.stream().mapToDouble(Product::getNettopreis).sum();

        invoice.setKontaktId(request.getKontaktId());
        invoice.setRechnungsdatum(request.getRechnungsdatum());
        invoice.setBruttobetrag(bruttoBetrag);
        invoice.setLeistungsbezeichnung(request.getLeistungsbezeichnung());
        invoice.setStatus(request.getStatus());
        invoice.setZahlungsfrist(request.getZahlungsfrist());
        invoice.setProdukte(request.getProdukte().stream().map(productMapper::toProduct).toList());
    }
}