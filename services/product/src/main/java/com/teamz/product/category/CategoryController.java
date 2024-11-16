package com.teamz.product.category;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/category")
@AllArgsConstructor
public class CategoryController {
    private final CategoryService categoryService;

    // Add category
    @PostMapping
    public ResponseEntity<Integer> createCategory(
            @RequestBody @Valid CategoryRequest request
    ) {
        return ResponseEntity.ok(categoryService.createCategory(request));
    }

    // Update category details
    @PutMapping
    public ResponseEntity<Integer> updateCategory(
            @RequestBody @Valid UpdateCategoryRequest request
    ) {
        return ResponseEntity.ok(categoryService.updateCategory(request));
    }

    //TODO: Remove category
    // Ask to delete all products in the category or assign a new category to the products
}
