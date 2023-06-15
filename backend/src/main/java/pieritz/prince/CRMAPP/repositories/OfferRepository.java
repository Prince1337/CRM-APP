package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Offer;

@RepositoryRestResource
public interface OfferRepository extends JpaRepository<Offer, Long> {
}