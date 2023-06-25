package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse getProductById(Long id);
    Page<ProductResponse> getAllProducts(Pageable pageable);
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);

    Page<ProductResponse> findByGruppe(String gruppe, Pageable pageable);
    Page<ProductResponse> findByStatus(String status, Pageable pageable);
    Page<ProductResponse> findByNettopreisLessThan(double nettopreis, Pageable pageable);
    Page<ProductResponse> findByBezeichnungContainingIgnoreCase(String keyword, Pageable pageable);
    Page<ProductResponse> findByGruppeAndStatus(String gruppe, String status, Pageable pageable);
    Page<ProductResponse> findByNettopreisBetween(double minNettopreis, double maxNettopreis, Pageable pageable);
    Page<ProductResponse> findByGruppeOrderByBezeichnungAsc(String gruppe, Pageable pageable);
    Page<ProductResponse> findByStatusOrderByNettopreisDesc(String status, Pageable pageable);
    Page<ProductResponse> findTop5ByOrderByNettopreisDesc(Pageable pageable);
    Page<ProductResponse> findDistinctByGruppe(String gruppe, Pageable pageable);
    Page<ProductResponse> findByBezeichnungLike(String pattern, Pageable pageable);
    Page<ProductResponse> findByBezeichnungStartingWith(String prefix, Pageable pageable);
    Page<ProductResponse> findByNotizenIsNull(Pageable pageable);
    Page<ProductResponse> findByNotizenIsNotNull(Pageable pageable);
    Page<ProductResponse> findByBezeichnungIn(List<String> bezeichnungen, Pageable pageable);
    Page<ProductResponse> findByStatusNot(String status, Pageable pageable);
    Page<ProductResponse> findByGruppeIgnoreCase(String gruppe, Pageable pageable);
    Page<ProductResponse> findByNettopreisGreaterThanEqual(double nettopreis, Pageable pageable);
    Page<ProductResponse> findByBezeichnungIgnoreCaseAndStatus(String bezeichnung, String status, Pageable pageable);
    Page<ProductResponse> findByGruppeAndNettopreisLessThanEqual(String gruppe, double nettopreis, Pageable pageable);
}
