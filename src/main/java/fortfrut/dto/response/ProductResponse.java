package fortfrut.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
  DTO de saída utilizado para retornar os dados de um produto ao cliente.
  Inclui informações resumidas como o nome da categoria, sem expor a entidade diretamente.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    // Identificador único do produto
    private Long id;

    // Nome do produto
    private String name;

    // Quantidade disponível em estoque
    private Integer quantity;

    // Preço do produto.
    private Double price;

    // Data de validade do produto.
    private LocalDate expirationDate;

    // Data e hora em que o produto foi cadastrado
    private LocalDateTime createdAt;

    // Nome da categoria à qual o produto pertence
    private String categoryName;
}
