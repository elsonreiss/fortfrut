package fortfrut.service;


import fortfrut.dto.ProductMapper;
import fortfrut.dto.request.ProductRequest;
import fortfrut.dto.response.ProductResponse;
import fortfrut.entity.Category;
import fortfrut.entity.Product;
import fortfrut.repository.CategoryRepository;
import fortfrut.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;

    private final CategoryRepository categoryRepository;

    // Retorna todos os produtos cadastrados convertidos para ProductResponse
    public List<ProductResponse> findAll() {
        return productRepository.findAll()
                .stream()
                .map(ProductMapper::toResponse)
                .toList();
    }

    // Busca um produto pelo ID e o retorna como ProductResponse. Lança exceção se não encontrado
    public ProductResponse findById(Long id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));
        return ProductMapper.toResponse(product);
    }

    /**
      Cria um novo produto a partir dos dados do ProductRequest.
      Se informado, associa a categoria correspondente ao produto antes de salvar.
     */
    public ProductResponse save(ProductRequest productRequest) {
        Product product = ProductMapper.toEntity(productRequest);

        if (productRequest.getCategoryId() != null) {
            Category category = categoryRepository.findById(productRequest.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + productRequest.getCategoryId()));
            product.setCategory(category);
        }

        return ProductMapper.toResponse(productRepository.save(product));
    }

    /**
      Atualiza os dados de um produto existente pelo ID.
      Se informado, atualiza também a categoria associada.
     */
    public ProductResponse update(Long id, ProductRequest updatedProduct) {

        Product existingProduct = productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        existingProduct.setName(updatedProduct.getName());
        existingProduct.setQuantity(updatedProduct.getQuantity());
        existingProduct.setPrice(updatedProduct.getPrice());
        existingProduct.setExpirationDate(updatedProduct.getExpirationDate());

        if (updatedProduct.getCategoryId() != null) {
            Category category = categoryRepository.findById(updatedProduct.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found with id: " + updatedProduct.getCategoryId()));
            existingProduct.setCategory(category);
        }

        return ProductMapper.toResponse(productRepository.save(existingProduct));
    }

    public void delete(Long id) {
        findById(id);
        productRepository.deleteById(id);
    }
}

