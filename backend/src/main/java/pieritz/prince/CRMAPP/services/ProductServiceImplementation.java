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

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    public long getTotalProductCount() {
        return productRepository.count();
    }

    public double getAverageNetPrice() {
        return productRepository.getAverageNetPrice();
    }

    public Map<String, Long> getProductCountByGroup() {
        List<Object[]> results = productRepository.getProductCountByGroup();
        Map<String, Long> countByGroup = new HashMap<>();

        for (Object[] result : results) {
            String group = (String) result[0];
            long count = (long) result[1];
            countByGroup.put(group, count);
        }

        return countByGroup;
    }

    public long getProductCountByStatus(String status) {
        return productRepository.countByStatus(status);
    }

    public double getAverageTaxRate() {
        return productRepository.getAverageTaxRate();
    }


    @Override
    public Page<ProductResponse> searchProducts(String bezeichnung, String gruppe, String status, String notizen, Pageable pageable) {
        Page<Product> products = productRepository.findByBezeichnungContainingOrGruppeContainingOrStatusContainingOrNotizenContaining(bezeichnung, gruppe, status, notizen, pageable);
        return products.map(productMapper::toProductResponse);
    }


}
