package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.dto.InvoiceRequest;
import pieritz.prince.CRMAPP.dto.InvoiceResponse;

import java.util.List;

public interface InvoiceService {
    InvoiceResponse createInvoice(InvoiceRequest request);
    InvoiceResponse getInvoiceById(Long id);
    Page<InvoiceResponse> getAllInvoices(Pageable pageable);
    InvoiceResponse updateInvoice(Long id, InvoiceRequest request);
    void deleteInvoice(Long id);
}
