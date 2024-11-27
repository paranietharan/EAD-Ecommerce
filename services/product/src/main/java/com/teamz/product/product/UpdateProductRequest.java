package com.teamz.product.product;


import jakarta.validation.constraints.NotNull;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;

public record UpdateProductRequest(
        @NotNull(message = "Product ID is required")
        Long id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        Integer categoryId,
        MultipartFile productImg
) {
}
