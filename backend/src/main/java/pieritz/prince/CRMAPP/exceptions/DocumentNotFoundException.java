package pieritz.prince.CRMAPP.exceptions;

public class DocumentNotFoundException extends RuntimeException {
  public DocumentNotFoundException(String documentNotFound) {
    super(documentNotFound);
  }
}
