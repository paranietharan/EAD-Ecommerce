package com.teamz.product.product;

import com.teamz.product.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private double availableQuantity;
    private BigDecimal price;
    @Lob
    @Column(name = "product_img", columnDefinition = "LONGBLOB")
    private byte[] productImg;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}
