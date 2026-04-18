package fortfrut.controller;

import fortfrut.dto.request.ProductRequest;
import fortfrut.dto.response.ProductResponse;
import fortfrut.entity.Product;
import fortfrut.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll() {
        return ResponseEntity.ok(productService.findAll());
    }

    // Busca um produto pelo seu ID. Retorna 404 se não encontrado
    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findById(id));
    }

    // Cria um novo produto. Retorna 201 (Created) com os dados do produto criado
    @PostMapping
    public ResponseEntity<ProductResponse> save(@RequestBody ProductRequest product) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.save(product));
    }

    // Atualiza os dados de um produto existente pelo seu ID
    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductRequest product) {
        return ResponseEntity.ok(productService.update(id, product));
    }

    // Remove um produto pelo seu ID. Retorna 204 (No Content) em caso de sucesso
    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
