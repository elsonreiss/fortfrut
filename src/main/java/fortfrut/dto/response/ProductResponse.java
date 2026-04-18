package fortfrut.dto.response;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductResponse {

    private Long id;
    private String name;
    private Integer quantity;
    private Double price;
    private LocalDate expirationDate;
    private LocalDateTime createdAt;
    private String categoryName;
}
