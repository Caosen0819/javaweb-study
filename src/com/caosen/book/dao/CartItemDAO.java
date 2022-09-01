package com.caosen.book.dao;

import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.User;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/19 11:16
 * @Version 1.0
 */
public interface CartItemDAO {
    void addCartItem(CartItem cartItem);
    void updateCartItem(CartItem cartItem);
    //void addOrUpdateCartItem(CartItem cartItem);

    List<CartItem> getCartItemList(User user);

    void  deCartItem(CartItem cartItem);
}
