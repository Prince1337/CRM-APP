package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Contact;

@RepositoryRestResource
public interface ContactRepository extends JpaRepository<Contact, Long> {

}

