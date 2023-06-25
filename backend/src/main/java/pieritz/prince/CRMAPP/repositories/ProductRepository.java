package pieritz.prince.CRMAPP.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import pieritz.prince.CRMAPP.domain.Product;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends JpaRepository<Product, Long> {
  Page<Product> findByGruppe(String gruppe, Pageable pageable);
  Page<Product> findByStatus(String status, Pageable pageable);
  Page<Product> findByNettopreisLessThan(double nettopreis, Pageable pageable);
  Page<Product> findByBezeichnungContainingIgnoreCase(String keyword, Pageable pageable);
  Page<Product> findByGruppeAndStatus(String gruppe, String status, Pageable pageable);
  Page<Product> findByNettopreisBetween(double minNettopreis, double maxNettopreis, Pageable pageable);
  Page<Product> findByGruppeOrderByBezeichnungAsc(String gruppe, Pageable pageable);
  Page<Product> findByStatusOrderByNettopreisDesc(String status, Pageable pageable);
  Page<Product> findTop5ByOrderByNettopreisDesc(Pageable pageable);
  Page<Product> findDistinctByGruppe(String gruppe, Pageable pageable);
  Page<Product> findByBezeichnungLike(String pattern, Pageable pageable);
  Page<Product> findByBezeichnungStartingWith(String prefix, Pageable pageable);
  Page<Product> findByNotizenIsNull(Pageable pageable);
  Page<Product> findByNotizenIsNotNull(Pageable pageable);
  Page<Product> findByBezeichnungIn(List<String> bezeichnungen, Pageable pageable);
  Page<Product> findByStatusNot(String status, Pageable pageable);
  Page<Product> findByGruppeIgnoreCase(String gruppe, Pageable pageable);
  Page<Product> findByNettopreisGreaterThanEqual(double nettopreis, Pageable pageable);
  Page<Product> findByBezeichnungIgnoreCaseAndStatus(String bezeichnung, String status, Pageable pageable);
  Page<Product> findByGruppeAndNettopreisLessThanEqual(String gruppe, double nettopreis, Pageable pageable);
}

