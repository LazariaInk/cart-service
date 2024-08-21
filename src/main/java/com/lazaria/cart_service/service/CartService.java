package com.lazaria.cart_service.service;

import com.lazaria.cart_service.model.Cart;
import com.lazaria.cart_service.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    CartRepository cartRepository;

    public Cart findCartById(Long id) {
        return cartRepository.getReferenceById(id);
    }

    public List<Cart> findAllCarts() {
        return cartRepository.findAll();
    }

    public void deleteCartById(Long id) {
        cartRepository.deleteById(id);
    }

    public void editCartById(Long id, Cart cart) {
        Cart cartToEdit = cartRepository.getReferenceById(id);
        cartToEdit.setItems(cart.getItems());
        cartRepository.save(cartToEdit);
    }
}
