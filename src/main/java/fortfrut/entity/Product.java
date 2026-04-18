package fortfrut.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tb_products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Nome do produto. Não pode ser nulo
    @Column(nullable = false)
    private String name;

    // Quantidade disponível em estoque. Não pode ser nulo
    @Column(nullable = false)
    private Integer quantity;

    // Preço do produto. Não pode ser nulo
    @Column(nullable = false)
    private double price;

    // Data de validade do produto. Não pode ser nulo
    @Column(nullable = false)
    private LocalDate expirationDate;

    // Data e hora em que o produto foi cadastrado. Preenchido automaticamente e não pode ser alterado
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    /**
     * Método executado automaticamente antes de salvar o produto pela primeira vez.
     * Preenche o campo createdAt com a data e hora atual.
     */
    @PrePersist
    protected void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    // Categoria à qual o produto pertence
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
