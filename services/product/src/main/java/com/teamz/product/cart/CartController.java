package com.teamz.product.cart;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    //Add items to cart
    @PostMapping
    public ResponseEntity<Integer> addItemToCart(
            @RequestParam Long productId,
            @RequestParam int quantity,
            @RequestParam Long userId
    ) {
        cartService.addItemToCart(productId, quantity, userId);
        return ResponseEntity.ok().build();
    }
    // TODO: Remove items from cart
    // TODO: Get items from cart
    // TODO: Update items in cart(change quantity)
}
