package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Contact;

import java.util.List;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {
  Page<Contact> findByVornameContainingIgnoreCaseOrNameContainingIgnoreCase(String vorname, String name, Pageable pageable);
  long countByFirma(String firma);
  long countByEmailContaining(String email);
  Page<Contact> findByBranche(String branche, Pageable pageable);
}

