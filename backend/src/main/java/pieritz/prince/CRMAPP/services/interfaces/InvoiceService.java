package pieritz.prince.CRMAPP.services.interfaces;

import pieritz.prince.CRMAPP.dto.InvoiceRequest;
import pieritz.prince.CRMAPP.dto.InvoiceResponse;

import java.util.List;

public interface InvoiceService {
    InvoiceResponse createInvoice(InvoiceRequest request);
    InvoiceResponse getInvoiceById(Long id);
    List<InvoiceResponse> getAllInvoices();
    InvoiceResponse updateInvoice(Long id, InvoiceRequest request);
    void deleteInvoice(Long id);
}
