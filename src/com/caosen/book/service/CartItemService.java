package com.caosen.book.service;

import com.caosen.book.pojo.Cart;
import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.User;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/19 11:41
 * @Version 1.0
 */
public interface CartItemService {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    void addOrUpdateCartItem(CartItem cartItem, Cart cart);
    List<CartItem> getCartItemList(User user);
    Cart getCart(User user);
}
