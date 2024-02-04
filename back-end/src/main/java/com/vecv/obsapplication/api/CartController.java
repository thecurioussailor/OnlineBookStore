package com.vecv.obsapplication.api;

import com.vecv.obsapplication.models.Cart;
import com.vecv.obsapplication.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class CartController {

    private CartRepository cartRepository;

    @Autowired
    public CartController(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GetMapping("/carts")
    public List<Cart> cartList() {
        return cartRepository.findAll();
    }

    @GetMapping("/carts/{cartId}")
    public ResponseEntity<Cart> getCartById(@PathVariable Long cartId){

        Optional<Cart> optionalCart = cartRepository.findById(cartId);

        if (optionalCart.isPresent()){
            return ResponseEntity.ok(optionalCart.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }

    // Create a new Cart
    @PostMapping("/carts")
    public ResponseEntity<Cart> createCart(@RequestBody Cart cart){

        //save the cart
        Cart createCart = cartRepository.save(cart);

        return ResponseEntity.status(HttpStatus.CREATED).body(createCart);

    }

    @DeleteMapping("/carts/{cartId}")
    public ResponseEntity<Void> deleteCart(@PathVariable Long cartId) {
        Optional<Cart> optionalCart = cartRepository.findById(cartId);

        if (optionalCart.isPresent()) {
            Cart cart = optionalCart.get();

            // Delete the cart
            cartRepository.delete(cart);

            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}

