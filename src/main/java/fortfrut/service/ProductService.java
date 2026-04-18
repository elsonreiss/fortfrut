package fortfrut.service;


import fortfrut.entity.Product;
import fortfrut.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
    }

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public Product update(Long id, Product updatedProduct) {

        Product existingProduct = findById(id);

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setExpirationDate(updatedProduct.getExpirationDate());

        return productRepository.save(existingProduct);
    }

    public void delete(Long id) {
        Product existingProduct = findById(id);
        productRepository.delete(existingProduct);
    }
}

