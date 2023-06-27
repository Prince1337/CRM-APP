package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pieritz.prince.CRMAPP.domain.Settings;
import pieritz.prince.CRMAPP.dto.SettingsRequest;
import pieritz.prince.CRMAPP.dto.SettingsResponse;
import pieritz.prince.CRMAPP.exceptions.SettingsNotFoundException;
import pieritz.prince.CRMAPP.repositories.SettingsRepository;
import pieritz.prince.CRMAPP.services.interfaces.SettingsService;

@Service
@Transactional
@RequiredArgsConstructor
public class SettingsServiceImplementation implements SettingsService {
    private final SettingsRepository settingsRepository;

    @Override
    public SettingsResponse getSettings() {
        Settings settings = settingsRepository.findById(1L)
                .orElseThrow(() -> new SettingsNotFoundException("Settings not found"));
        return toSettingsResponse(settings);
    }

    @Override
    public SettingsResponse updateSettings(SettingsRequest request) {
        Settings settings = settingsRepository.findById(1L)
                .orElseThrow(() -> new SettingsNotFoundException("Settings not found"));

        updateSettingsFromRequest(request, settings);
        settings = settingsRepository.save(settings);
        return toSettingsResponse(settings);
    }

    private void updateSettingsFromRequest(SettingsRequest request, Settings settings) {
        settings.setMeinUnternehmen(request.getMeinUnternehmen());
        settings.setAnsprechpartner(request.getAnsprechpartner());
        settings.setStrasse(request.getStrasse());
        settings.setPlz(request.getPlz());
        settings.setStadt(request.getStadt());
        settings.setTelefon(request.getTelefon());
        settings.setMail(request.getMail());
        settings.setWebseite(request.getWebseite());
        settings.setUstIdNr(request.getUstIdNr());
        settings.setIban(request.getIban());
        settings.setBic(request.getBic());
        settings.setSynchronisierung(request.getSynchronisierung());
        settings.setAnnahmefristAngebote(request.getAnnahmefristAngebote());
        settings.setAngebotSenden(request.isAngebotSenden());
        settings.setRechnungSenden(request.isRechnungSenden());
        settings.setKontaktkategorien(request.getKontaktkategorien());
    }

    private SettingsResponse toSettingsResponse(Settings settings) {
        return SettingsResponse.builder()
                .meinUnternehmen(settings.getMeinUnternehmen())
                .ansprechpartner(settings.getAnsprechpartner())
                .strasse(settings.getStrasse())
                .plz(settings.getPlz())
                .stadt(settings.getStadt())
                .telefon(settings.getTelefon())
                .mail(settings.getMail())
                .webseite(settings.getWebseite())
                .ustIdNr(settings.getUstIdNr())
                .iban(settings.getIban())
                .bic(settings.getBic())
                .synchronisierung(settings.getSynchronisierung())
                .annahmefristAngebote(settings.getAnnahmefristAngebote())
                .angebotSenden(settings.isAngebotSenden())
                .rechnungSenden(settings.isRechnungSenden())
                .kontaktkategorien(settings.getKontaktkategorien())
                .build();
    }
}

