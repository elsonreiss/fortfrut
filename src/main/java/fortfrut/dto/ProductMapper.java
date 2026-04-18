package fortfrut.dto;

import fortfrut.dto.request.ProductRequest;
import fortfrut.dto.response.ProductResponse;
import fortfrut.entity.Product;

public class ProductMapper {

    /**
      Converte uma entidade Product para um ProductResponse (DTO de saída).
      O campo categoryName é preenchido com o nome da categoria, se houver.
     */
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

    /**
      Converte um ProductRequest (DTO de entrada) para a entidade Product.
      A categoria não é definida aqui — deve ser associada separadamente no serviço.
     */
    public static Product toEntity(ProductRequest request) {
        return Product.builder()
                .name(request.getName())
                .quantity(request.getQuantity())
                .price(request.getPrice())
                .expirationDate(request.getExpirationDate())
                .build();
    }
}
