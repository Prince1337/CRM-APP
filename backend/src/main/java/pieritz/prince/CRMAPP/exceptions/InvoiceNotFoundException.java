package pieritz.prince.CRMAPP.exceptions;

public class InvoiceNotFoundException extends RuntimeException {
  public InvoiceNotFoundException(String invoiceNotFound) {
    super(invoiceNotFound);
  }
}
