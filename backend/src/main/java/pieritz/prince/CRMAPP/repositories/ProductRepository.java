package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Product;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
}
