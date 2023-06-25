package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pieritz.prince.CRMAPP.domain.Product;
import pieritz.prince.CRMAPP.dto.ProductMapper;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;
import pieritz.prince.CRMAPP.exceptions.ProductNotFoundException;
import pieritz.prince.CRMAPP.repositories.ProductRepository;
import pieritz.prince.CRMAPP.services.interfaces.ProductService;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = productMapper.toProduct(request);
        product = productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));
        return productMapper.toProductResponse(product);
    }

    @Override
    public Page<ProductResponse> getAllProducts(Pageable pageable) {
        Page<Product> products = productRepository.findAll(pageable);
        List<ProductResponse> productResponses = products.getContent().stream()
                .map(productMapper::toProductResponse)
                .toList();
        return new PageImpl<>(productResponses, pageable, products.getTotalElements());
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));


        productMapper.updateProductFromRequest(request, product);
        product = productRepository.save(product);
        return productMapper.toProductResponse(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        productRepository.delete(product);
    }

    @Override
    public Page<ProductResponse> findByGruppe(String gruppe, Pageable pageable) {
        Page<Product> products = productRepository.findByGruppe(gruppe, pageable);
        List<ProductResponse> productResponses = products.getContent().stream()
                .map(productMapper::toProductResponse)
                .toList();
        return new PageImpl<>(productResponses, pageable, products.getTotalElements());
    }

    @Override
    public Page<ProductResponse> findByStatus(String status, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByNettopreisLessThan(double nettopreis, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByBezeichnungContainingIgnoreCase(String keyword, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByGruppeAndStatus(String gruppe, String status, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByNettopreisBetween(double minNettopreis, double maxNettopreis, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByGruppeOrderByBezeichnungAsc(String gruppe, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByStatusOrderByNettopreisDesc(String status, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findTop5ByOrderByNettopreisDesc(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findDistinctByGruppe(String gruppe, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByBezeichnungLike(String pattern, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByBezeichnungStartingWith(String prefix, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByNotizenIsNull(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByNotizenIsNotNull(Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByBezeichnungIn(List<String> bezeichnungen, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByStatusNot(String status, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByGruppeIgnoreCase(String gruppe, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByNettopreisGreaterThanEqual(double nettopreis, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByBezeichnungIgnoreCaseAndStatus(String bezeichnung, String status, Pageable pageable) {
        return null;
    }

    @Override
    public Page<ProductResponse> findByGruppeAndNettopreisLessThanEqual(String gruppe, double nettopreis, Pageable pageable) {
        return null;
    }


}
