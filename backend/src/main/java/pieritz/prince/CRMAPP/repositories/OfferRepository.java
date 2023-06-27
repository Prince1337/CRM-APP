package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Invoice;
import pieritz.prince.CRMAPP.domain.Offer;

@RepositoryRestResource
public interface OfferRepository extends JpaRepository<Offer, Long> {
  Page<Offer> findByKontaktId(Long kontaktId, Pageable pageable);
  long countByStatus(String status);
  Page<Offer> findByLeistungsbezeichnung(String leistungsbezeichnung, Pageable pageable);


}
