package pieritz.prince.CRMAPP.dto;

import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Product;

@Component
public class ProductMapper {
    public ProductMapper() {
    }

    public Product toProduct(ProductRequest request) {
        return Product.builder()
                .bezeichnung(request.getBezeichnung())
                .nettopreis(request.getNettopreis())
                .umst(request.getUmst())
                .gruppe(request.getGruppe())
                .status(request.getStatus())
                .notizen(request.getNotizen())
                .build();
    }

    public ProductResponse toProductResponse(Product product) {
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
}