package com.teamz.product.category;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public Integer createCategory(@Valid CategoryRequest request) {
        Category category = Category.builder()
                .name(request.name())
                .description(request.description())
                .build();
        return repository.save(category).getId();
    }

    public Integer updateCategory(@Valid UpdateCategoryRequest request) {
        Category category = repository.findById(request.id())
                .orElseThrow(() -> new IllegalArgumentException("Category not found"));
        category.setName(request.name());
        category.setDescription(request.description());
        return repository.save(category).getId();
    }

    public List<CategoryResponse> getAllCategories() {
        return repository.findAll().stream()
                .map(category -> new CategoryResponse(
                        category.getId(),
                        category.getName(),
                        category.getDescription()
                ))
                .toList();
    }
}
