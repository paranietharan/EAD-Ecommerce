package com.teamz.product.product;

import com.teamz.product.Wishlist.WishList;
import com.teamz.product.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

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

    @ManyToMany(mappedBy = "wishListItems")
    private List<WishList> wishLists;
}
