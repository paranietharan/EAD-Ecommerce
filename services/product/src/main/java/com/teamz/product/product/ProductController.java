package com.teamz.product.product;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    // Adding a new product -tested
    @PostMapping
    public ResponseEntity<Long> createProduct(
            @RequestBody @Valid ProductRequest request
    ) {
        return ResponseEntity.ok(service.createProduct(request));
    }

    // Getting a product by id - tested
    @GetMapping("/{product-id}")
    public ResponseEntity<ProductResponse> findById(
            @PathVariable("product-id") Long productId
    ) {
        return ResponseEntity.ok(service.findById(productId));
    }

    // Getting all products - tested
    @GetMapping
    public ResponseEntity<Page<ProductResponse>> findAll(
            @RequestParam(defaultValue = "1") int page,
            @RequestParam(defaultValue = "100") int limit,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return ResponseEntity.ok(service.findAll(page, limit, sortBy));
    }

    // Updating a product
    @PutMapping
    public ResponseEntity<Void> updateProduct(@RequestBody @Valid UpdateProductRequest request) {
        service.updateProduct(request);
        return ResponseEntity.noContent().build();
    }

    // Deleting a product
    @DeleteMapping("/{product-id}")
    public ResponseEntity<Void> deleteProduct(
            @PathVariable("product-id") Long productId
    ) {
        service.deleteProduct(productId);
        return ResponseEntity.noContent().build();
    }
}
