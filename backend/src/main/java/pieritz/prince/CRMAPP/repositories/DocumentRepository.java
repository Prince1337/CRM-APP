package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Contact;
import pieritz.prince.CRMAPP.domain.Document;

@RepositoryRestResource
public interface DocumentRepository extends JpaRepository<Document, Long> {
  Page<Document> findByKontaktId(Long kontaktId, Pageable pageable);
  long countByArt(String art);
  Page<Document> findByDateityp(String dateityp, Pageable pageable);
}
