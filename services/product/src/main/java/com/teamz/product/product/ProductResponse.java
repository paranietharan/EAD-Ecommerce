package com.teamz.product.product;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        String description,
        double availableQuantity,
        BigDecimal price,
        byte[] productImg,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
