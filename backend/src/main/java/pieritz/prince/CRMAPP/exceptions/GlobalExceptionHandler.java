package pieritz.prince.CRMAPP.exceptions;

import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ProductNotFoundException.class)
  public ResponseEntity<String> handleProductNotFoundException(ProductNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(ContactNotFoundException.class)
  public ResponseEntity<String> handleContactNotFoundException(ContactNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(OfferNotFoundException.class)
  public ResponseEntity<String> handleOfferNotFoundException(OfferNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(DocumentNotFoundException.class)
  public ResponseEntity<String> handleDocumentNotFoundException(DocumentNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(InvoiceNotFoundException.class)
  public ResponseEntity<String> handleInvoiceNotFoundException(InvoiceNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(SettingsNotFoundException.class)
  public ResponseEntity<String> handleSettingsNotFoundException(SettingsNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(TaskNotFoundException.class)
  public ResponseEntity<String> handleTaskNotFoundException(TaskNotFoundException ex) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
  }

  @ExceptionHandler(ExpiredJwtException.class)
  public ResponseEntity<String> handleExpiredJwtException(ExpiredJwtException ex) {
    String errorMessage = "JWT expired at " + ex.getClaims().getExpiration() + ". Current time: " + ex.getClaims().get("current_time") + ", a difference of " + ex.getClaims().get("difference") + " milliseconds. Allowed clock skew: " + ex.getClaims().get("clock_skew") + " milliseconds.";
    return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorMessage);
  }

  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<Object> handleAccessDeniedException(AccessDeniedException ex) {
    // Hier kannst du die gewünschte Antwort erstellen, z.B. eine Fehlermeldung oder einen anderen HTTP-Statuscode
    return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Zugriff verweigert");
  }

  @ExceptionHandler(DataIntegrityViolationException.class)
  public ResponseEntity<String> handleDataIntegrityViolationException(DataIntegrityViolationException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Data integrity violation: " + ex.getMessage());
  }

  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> handleInternalException(Exception ex) {
    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ein Fehler ist aufgetreten: " + ex.getMessage());
  }


}
