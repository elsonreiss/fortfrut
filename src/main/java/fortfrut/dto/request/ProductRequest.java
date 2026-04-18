package fortfrut.dto.request;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
  DTO de entrada utilizado para criar ou atualizar um produto.
  Recebe os dados enviados pelo cliente na requisição.
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductRequest {

    private String name;

    private Integer quantity;

    private Double price;

    private LocalDate expirationDate;

    private Long categoryId;
}
