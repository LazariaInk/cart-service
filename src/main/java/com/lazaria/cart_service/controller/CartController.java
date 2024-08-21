package com.lazaria.cart_service.controller;

import com.lazaria.cart_service.model.Cart;
import com.lazaria.cart_service.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartController {
    @Autowired
    CartService cartService;

    @GetMapping("/cart/{id}")
    public Cart getCartById(@PathVariable long id) {
        return cartService.findCartById(id);
    }

    @GetMapping("/cart/all")
    public List<Cart> getAllCarts() {
        return cartService.findAllCarts();
    }

    @DeleteMapping("/cart/{id}/delete")
    public void deleteCartById(@PathVariable long id) {
        cartService.deleteCartById(id);
    }

    @PutMapping("/cart/edit{id}")
    public void editCartById(@PathVariable long id, Cart cart) {
        cartService.editCartById(id, cart);
    }
}
