package com.teamz.product.cart;

import com.teamz.product.product.Product;
import com.teamz.product.product.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CartService {
    private final CartRepository cartRepository;
    private final CartItemRepository cartItemRepository;
    private final ProductRepository productRepository;

    public void addItemToCart(Long productId, int quantity, Long userId) {
        // Get cart from user
        Cart cart = cartRepository.findByUserId(userId);

        // If cart is not found, create a new cart for the user
        // cart not be there if user is new
        if (cart == null) {
            cart = new Cart();
            cart.setUserId(userId);
            cart = cartRepository.save(cart);
        }

        // Check if the product is already in the cart
        CartItem cartItem = cartItemRepository.findByCartIdAndProductId(cart.getId(), productId);

        // If the product is already in the cart, update the quantity
        if (cartItem != null) {
            cartItem.setQuantity(cartItem.getQuantity() + quantity);
            cartItemRepository.save(cartItem);
        } else {
            // If the product is not in the cart, add the product to the cart
            cartItem = CartItem.builder()
                    .cart(cart)
                    .product(
                            productRepository.findById(productId)
                                    .orElseThrow(() -> new RuntimeException("Product not found with id: " + productId))
                    )
                    .quantity(quantity)
                    .build();
            cartItemRepository.save(cartItem);
        }

    }
}
