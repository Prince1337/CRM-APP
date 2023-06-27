package pieritz.prince.CRMAPP.web;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pieritz.prince.CRMAPP.domain.Product;
import pieritz.prince.CRMAPP.dto.ProductRequest;
import pieritz.prince.CRMAPP.dto.ProductResponse;
import pieritz.prince.CRMAPP.exceptions.ProductNotFoundException;
import pieritz.prince.CRMAPP.services.interfaces.ProductService;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
@CrossOrigin(originPatterns = "http://localhost:4200")
@RequiredArgsConstructor
public class ProductController {
    private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody ProductRequest request) {
            ProductResponse response = productService.createProduct(request);
            logger.info("Product created successfully");
            return ResponseEntity.ok(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProduct(@PathVariable Long id) {
        logger.info("Received request to get product with ID: {}", id);
            ProductResponse response = productService.getProductById(id);
            logger.info("Product retrieved successfully");
            return ResponseEntity.ok(response);

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

    @GetMapping("/total-count")
    public ResponseEntity<Long> getTotalProductCount() {
        long totalCount = productService.getTotalProductCount();
        return ResponseEntity.ok(totalCount);
    }

    @GetMapping("/average-net-price")
    public ResponseEntity<Double> getAverageNetPrice() {
        double averageNetPrice = productService.getAverageNetPrice();
        System.out.println("test");
        return ResponseEntity.ok(averageNetPrice);
    }

    @GetMapping("/count-by-group")
    public ResponseEntity<Map<String, Long>> getProductCountByGroup() {
        Map<String, Long> countByGroup = productService.getProductCountByGroup();
        return ResponseEntity.ok(countByGroup);
    }

    @GetMapping("/count-by-status")
    public ResponseEntity<Long> getProductCountByStatus(@RequestParam("status") String status) {
        long count = productService.getProductCountByStatus(status);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/average-tax-rate")
    public ResponseEntity<Double> getAverageTaxRate() {
        double averageTaxRate = productService.getAverageTaxRate();
        return ResponseEntity.ok(averageTaxRate);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductResponse>> searchProducts(@RequestParam(required = false) String bezeichnung,
                                                                @RequestParam(required = false) String gruppe,
                                                                @RequestParam(required = false) String status,
                                                                @RequestParam(required = false) String notizen,
                                                                Pageable pageable) {
        Page<ProductResponse> responses = productService.searchProducts(bezeichnung, gruppe, status, notizen, pageable);
        return ResponseEntity.ok(responses);
    }
}
