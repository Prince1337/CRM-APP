package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Product;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
  @Query("SELECT AVG(p.nettopreis) FROM Product p")
  double getAverageNetPrice();

  @Query("SELECT p.gruppe, COUNT(p) FROM Product p GROUP BY p.gruppe")
  List<Object[]> getProductCountByGroup();

  long countByStatus(String status);

  @Query("SELECT AVG(p.umst) FROM Product p")
  double getAverageTaxRate();

  Page<Product> findByBezeichnungContainingOrGruppeContainingOrStatusContainingOrNotizenContaining(
          String bezeichnung, String gruppe, String status, String notizen, Pageable pageable);
}

