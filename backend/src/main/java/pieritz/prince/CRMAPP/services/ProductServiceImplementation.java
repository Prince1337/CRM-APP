package pieritz.prince.CRMAPP.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pieritz.prince.CRMAPP.domain.Product;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;
import pieritz.prince.CRMAPP.repositories.ProductRepository;
import pieritz.prince.CRMAPP.services.interfaces.ProductService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class ProductServiceImplementation implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public ProductResponse createProduct(ProductRequest request) {
        Product product = toProduct(request);
        product = productRepository.save(product);
        return toProductResponse(product);
    }

    @Override
    public ProductResponse getProductById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        return toProductResponse(product);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(this::toProductResponse)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse updateProduct(Long id, ProductRequest request) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        updateProductFromRequest(request, product);
        product = productRepository.save(product);
        return toProductResponse(product);
    }

    @Override
    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found"));
        productRepository.delete(product);
    }

    private Product toProduct(ProductRequest request) {
        return Product.builder()
                .bezeichnung(request.getBezeichnung())
                .nettopreis(request.getNettopreis())
                .umst(request.getUmst())
                .gruppe(request.getGruppe())
                .status(request.getStatus())
                .notizen(request.getNotizen())
                .build();
    }

    private ProductResponse toProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .bezeichnung(product.getBezeichnung())
                .nettopreis(product.getNettopreis())
                .umst(product.getUmst())
                .gruppe(product.getGruppe())
                .status(product.getStatus())
                .notizen(product.getNotizen())
                .build();
    }

    private void updateProductFromRequest(ProductRequest request, Product product) {
        product.setBezeichnung(request.getBezeichnung());
        product.setNettopreis(request.getNettopreis());
        product.setUmst(request.getUmst());
        product.setGruppe(request.getGruppe());
        product.setStatus(request.getStatus());
        product.setNotizen(request.getNotizen());
    }

}
