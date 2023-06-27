package pieritz.prince.CRMAPP.exceptions;

public class SettingsNotFoundException extends RuntimeException {
  public SettingsNotFoundException(String settingsNotFound) {
    super(settingsNotFound);
  }
}
