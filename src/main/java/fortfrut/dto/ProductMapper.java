package fortfrut.dto;

import fortfrut.dto.request.ProductRequest;
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

    public static Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .expirationDate(request.getExpirationDate())
                .build();
    }
}
