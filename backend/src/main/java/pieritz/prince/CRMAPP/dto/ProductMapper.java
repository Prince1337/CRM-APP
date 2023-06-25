package pieritz.prince.CRMAPP.dto;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;
import pieritz.prince.CRMAPP.domain.Product;

@Component
@NoArgsConstructor
public class ProductMapper {

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

    public void updateProductFromRequest(ProductRequest request, Product product) {
        product.setBezeichnung(request.getBezeichnung());
        product.setNettopreis(request.getNettopreis());
        product.setUmst(request.getUmst());
        product.setGruppe(request.getGruppe());
        product.setStatus(request.getStatus());
        product.setNotizen(request.getNotizen());
    }
}