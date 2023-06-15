package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import pieritz.prince.CRMAPP.domain.Settings;

@RepositoryRestResource
public interface SettingsRepository extends JpaRepository<Settings, Long> {
}
