package fortfrut.repository;

import fortfrut.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.expirationDate <= :limitDate")
    List<Product> findExpiringProducts(@Param("limitDate")LocalDate limitDate);

    @Query("SELECT p FROM Product p WHERE p.quantity <= :threshold")
    List<Product> findLowStockProducts(@Param("threshold") Integer threshold);
}
