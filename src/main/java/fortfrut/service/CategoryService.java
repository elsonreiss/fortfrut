package fortfrut.service;

import fortfrut.entity.Category;
import fortfrut.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    // Busca uma categoria pelo ID. Lança exceção se não encontrada
    public Category findCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));
    }

    // Atualiza o nome de uma categoria existente e salva as alterações
    public Category updateCategory(Long id, Category updatedCategory) {
        Category existingCategory = findCategoryById(id);
        existingCategory.setName(updatedCategory.getName());
        return categoryRepository.save(existingCategory);
    }

    // Remove uma categoria do banco de dados pelo ID
    public void deleteCategory(Long id) {
        Category existingCategory = findCategoryById(id);
        categoryRepository.delete(existingCategory);
    }
}
