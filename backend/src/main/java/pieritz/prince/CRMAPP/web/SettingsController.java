package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.SettingsRequest;
import pieritz.prince.CRMAPP.dto.SettingsResponse;
import pieritz.prince.CRMAPP.services.interfaces.SettingsService;

@RestController
@RequestMapping("/settings")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class SettingsController {
    private static final Logger logger = LoggerFactory.getLogger(SettingsController.class);
    private final SettingsService settingsService;

    @GetMapping
    public ResponseEntity<SettingsResponse> getSettings() {
        logger.info("Received request to get settings");
        SettingsResponse response = settingsService.getSettings();
        logger.info("Settings retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @PutMapping
    public ResponseEntity<SettingsResponse> updateSettings(@RequestBody SettingsRequest request) {
        logger.info("Received request to update settings");
        SettingsResponse response = settingsService.updateSettings(request);
        logger.info("Settings updated successfully");
        return ResponseEntity.ok(response);
    }
}

