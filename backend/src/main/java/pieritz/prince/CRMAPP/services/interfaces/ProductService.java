package pieritz.prince.CRMAPP.services.interfaces;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import pieritz.prince.CRMAPP.domain.Product;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;

import java.util.List;
import java.util.Map;

public interface ProductService {
    ProductResponse createProduct(ProductRequest request);
    ProductResponse getProductById(Long id);
    Page<ProductResponse> getAllProducts(Pageable pageable);
    ProductResponse updateProduct(Long id, ProductRequest request);
    void deleteProduct(Long id);
    long getTotalProductCount();
    double getAverageNetPrice();
    Map<String, Long> getProductCountByGroup();
    long getProductCountByStatus(String status);
    double getAverageTaxRate();
    Page<ProductResponse> searchProducts(String bezeichnung, String gruppe, String status, String notizen, Pageable pageable);
}
