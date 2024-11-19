package com.teamz.product.cart;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cart")
@AllArgsConstructor
public class CartController {
    private final CartService cartService;

    // Add items to cart
    @PostMapping
    public ResponseEntity<Integer> addItemToCart(
            @RequestParam Long productId,
            @RequestParam int quantity,
            @RequestParam Long userId
    ) {
        cartService.addItemToCart(productId, quantity, userId);
        return ResponseEntity.ok().build();
    }

    // Get items from cart
    @GetMapping
    public ResponseEntity<List<CartResponse>> getCartItems(
            @RequestParam Long userId
    ) {
        return ResponseEntity.ok(cartService.getCartItems(userId));
    }

    // TODO: Delete item from cart
}
