package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pieritz.prince.CRMAPP.domain.Invoice;
import pieritz.prince.CRMAPP.dto.*;
import pieritz.prince.CRMAPP.repositories.InvoiceRepository;
import pieritz.prince.CRMAPP.services.interfaces.InvoiceService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class InvoiceServiceImplementation implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final InvoiceMapper invoiceMapper;

    @Override
    public InvoiceResponse createInvoice(InvoiceRequest request) {
        Invoice invoice = invoiceMapper.toInvoice(request);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toInvoiceResponse(invoice);
    }

    @Override
    public InvoiceResponse getInvoiceById(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        return invoiceMapper.toInvoiceResponse(invoice);
    }

    @Override
    public Page<InvoiceResponse> getAllInvoices(Pageable pageable) {
        Page<Invoice> invoices = invoiceRepository.findAll(pageable);
        List<InvoiceResponse> invoiceResponses = invoices.getContent().stream()
                .map(invoiceMapper::toInvoiceResponse)
                .toList();
        return new PageImpl<>(invoiceResponses, pageable, invoices.getTotalElements());
    }

    @Override
    public InvoiceResponse updateInvoice(Long id, InvoiceRequest request) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));

        invoiceMapper.updateInvoiceFromRequest(request, invoice);
        invoice = invoiceRepository.save(invoice);
        return invoiceMapper.toInvoiceResponse(invoice);
    }

    @Override
    public void deleteInvoice(Long id) {
        Invoice invoice = invoiceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Invoice not found"));
        invoiceRepository.delete(invoice);
    }

}
