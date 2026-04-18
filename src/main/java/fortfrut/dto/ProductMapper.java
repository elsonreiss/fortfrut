package fortfrut.dto.request;

import fortfrut.dto.response.ProductResponse;
import fortfrut.entity.Product;

public class ProductMapper {

    public static ProductResponse toResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .quantity(product.getQuantity())
                .price(product.getPrice())
                .expirationDate(product.getExpirationDate())
                .createdAt(product.getCreatedAt())
                .categoryName(product.getCategory() != null
                        ? product.getCategory().getName()
                        : null)
                .build();
    }
}
