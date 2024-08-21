package com.lazaria.cart_service.service;

import com.lazaria.cart_service.model.CartItem;
import com.lazaria.cart_service.repository.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemService {
    @Autowired
    CartItemRepository cartItemRepository;

    public CartItem getCartItemById(Long id) {
        return cartItemRepository.getReferenceById(id);
    }

    public List<CartItem> getAllCartItems() {
        return cartItemRepository.findAll();
    }

    public void addCartItem(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    public void deleteCartItemById(Long id) {
        cartItemRepository.deleteById(id);
    }

    public void editCartItemById(CartItem cartItem, Long id) {
        CartItem cartItemToEdit = cartItemRepository.getReferenceById(id);
        cartItemToEdit.setCart(cartItem.getCart());
        cartItemToEdit.setQuantity(cartItemToEdit.getQuantity());
        cartItemToEdit.setPriceAtPurchase(cartItemToEdit.getPriceAtPurchase());
        cartItemToEdit.setProductId(cartItemToEdit.getProductId());
        cartItemRepository.save(cartItemToEdit);
    }
}
