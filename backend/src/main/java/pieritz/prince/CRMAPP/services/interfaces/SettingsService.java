package pieritz.prince.CRMAPP.services.interfaces;

import pieritz.prince.CRMAPP.dto.SettingsRequest;
import pieritz.prince.CRMAPP.dto.SettingsResponse;

public interface SettingsService {
    SettingsResponse getSettings();
    SettingsResponse updateSettings(SettingsRequest request);
}

