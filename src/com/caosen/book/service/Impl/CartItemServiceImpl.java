package com.caosen.book.service.Impl;

import com.caosen.book.dao.BookDAO;
import com.caosen.book.dao.CartItemDAO;
import com.caosen.book.pojo.Book;
import com.caosen.book.pojo.Cart;
import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.User;
import com.caosen.book.service.BookService;
import com.caosen.book.service.CartItemService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author Caosen
 * @Date 2022/7/19 11:42
 * @Version 1.0
 */
public class CartItemServiceImpl implements CartItemService {

    private CartItemDAO cartItemDAO;
    private BookService bookService;
    @Override
    public void addCartItem(CartItem cartItem) {
        cartItemDAO.addCartItem(cartItem);
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        cartItemDAO.updateCartItem(cartItem);
    }

    @Override
    public void addOrUpdateCartItem(CartItem cartItem, Cart cart) {
        if (cart != null) {
            Map<Integer, CartItem> cartItemMap = cart.getCartItemMap();
            if (cartItemMap == null) {
                cartItemMap = new HashMap<>();

            }
            if (cartItemMap.containsKey(cartItem.getBook().getId())){
                CartItem cartItem1 = cartItemMap.get(cartItem.getBook().getId());
                cartItem1.setBuyCount(cartItem1.getBuyCount() + 1);
                updateCartItem(cartItem1);
            }else {
                addCartItem(cartItem);
            }
        }else {
            addCartItem(cartItem);
        }
    }

    @Override
    public List<CartItem> getCartItemList(User user) {
        List<CartItem> cartItemList = cartItemDAO.getCartItemList(user);

        for(CartItem cartItem:cartItemList){
            Book book = bookService.getBook(cartItem.getBook().getId());
            cartItem.setBook(book);

        }


        return cartItemList;
    }

    @Override
    public Cart getCart(User user) {
        List<CartItem> cartItemList = getCartItemList(user);
        Map<Integer, CartItem> cartItemMap = new HashMap<>();
        for (CartItem cartItem : cartItemList){
            cartItemMap.put(cartItem.getBook().getId(), cartItem);
        }
        Cart cart = new Cart();
        cart.setCartItemMap(cartItemMap);
        cart.setTotalCount(cart.getTotalCount());
        cart.settotalBookCount(cart.getTotalBookCount());
        cart.setTotalMoney(cart.getTotalMoney());
        return cart;
    }
}
