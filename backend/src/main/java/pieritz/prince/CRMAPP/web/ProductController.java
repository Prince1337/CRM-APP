package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;
import pieritz.prince.CRMAPP.exceptions.ProductNotFoundException;
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
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
        try {
            ProductResponse response = productService.createProduct(request);
            logger.info("Product created successfully");
            return ResponseEntity.ok(response);
        } catch (DataIntegrityViolationException ex) {
            logger.info("Bad request, product not created");
            return ResponseEntity.badRequest().header("X-Validation-Error", ex.getMessage())
                .body(ex.getMessage());
        } catch (Exception ex) {
            logger.info("An error occurred while creating the product: ", ex);
            return ResponseEntity.badRequest().body(ex.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        logger.info("Received request to get product with ID: {}", id);
        try {
            ProductResponse response = productService.getProductById(id);
            logger.info("Product retrieved successfully");
            return ResponseEntity.ok(response);
        } catch (ProductNotFoundException ex) {
            logger.error("Product not found", ex);
            return ResponseEntity.status(404).body(ex.getMessage());
        } catch (Exception ex) {
            logger.info("An error occurred while creating the product", ex);
            return ResponseEntity.badRequest().build();
        }

    }

    @GetMapping
    public ResponseEntity<Page<ProductResponse>> getAllProducts(Pageable pageable) {
        logger.info("Received request to get all products");
        Page<ProductResponse> responses = productService.getAllProducts(pageable);
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
