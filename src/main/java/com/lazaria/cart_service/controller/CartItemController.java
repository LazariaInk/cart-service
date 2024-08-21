package com.lazaria.cart_service.controller;

import com.lazaria.cart_service.model.CartItem;
import com.lazaria.cart_service.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CartItemController {
    @Autowired
    CartItemService cartItemService;

    @GetMapping("/cart_item/{id}")
    public CartItem getCartItemById(@PathVariable long id) {
        return cartItemService.getCartItemById(id);
    }

    @GetMapping("/cart_item/all")
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @PostMapping("/cart_item/add")
    public void addCartItem(CartItem cartItem) {
        cartItemService.addCartItem(cartItem);
    }

    @DeleteMapping("/cart_item/delete{id}")
    public void deleteCartItemById(@PathVariable long id) {
        cartItemService.deleteCartItemById(id);
    }

    @PutMapping("/cart_item/edit{id}")
    public void editCartItemById(CartItem cartItem, @PathVariable long id) {
        cartItemService.editCartItemById(cartItem, id);
    }
}
