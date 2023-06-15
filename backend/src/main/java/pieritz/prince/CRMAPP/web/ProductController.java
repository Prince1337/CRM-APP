package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;
import pieritz.prince.CRMAPP.services.interfaces.ProductService;

import java.util.List;

@RestController
@RequestMapping("/products")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        logger.info("Received request to create product");
        ProductResponse response = productService.createProduct(request);
        logger.info("Product created successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable Long id) {
        logger.info("Received request to get product with ID: {}", id);
        ProductResponse response = productService.getProductById(id);
        logger.info("Product retrieved successfully");
        return ResponseEntity.ok(response);
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> getAllProducts() {
        logger.info("Received request to get all products");
        List<ProductResponse> responses = productService.getAllProducts();
        logger.info("Products retrieved successfully");
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> updateProduct(@PathVariable Long id, @RequestBody ProductRequest request) {
        logger.info("Received request to update product with ID: {}", id);
        ProductResponse response = productService.updateProduct(id, request);
        logger.info("Product updated successfully");
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        logger.info("Received request to delete product with ID: {}", id);
        productService.deleteProduct(id);
        logger.info("Product deleted successfully");
        return ResponseEntity.noContent().build();
    }
}
