package com.caosen.book.Controller;

import com.caosen.book.pojo.Book;
import com.caosen.book.pojo.Cart;
import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.User;
import com.caosen.book.service.CartItemService;

import javax.servlet.http.HttpSession;

/**
 * @Author Caosen
 * @Date 2022/7/19 11:14
 * @Version 1.0
 */
public class CartController {

    private CartItemService cartItemService;

    //加载用户购物车信息seesion
    public String index(HttpSession session){
        User user = (User) session.getAttribute("currUser");
        Cart cart = cartItemService.getCart(user);
        user.setCart(cart);
        session.setAttribute("currUser", user);
        return "cart/cart";


    }

    public String addCart(Integer bookId, HttpSession session){
        User currUser = (User)session.getAttribute("currUser");
        CartItem cartItem = new CartItem(new Book(bookId), 1, currUser);
        System.out.println("enter CartController");
        //如果已经有了则数量加一，否则新增设数量wei1
        cartItemService.addOrUpdateCartItem(cartItem, currUser.getCart());

        return "redirect:cart.do";
    }
    public String editCart(Integer cartItemId, Integer buyCount){
        System.out.println("edit Cart");
        cartItemService.updateCartItem(new CartItem(cartItemId, buyCount));

        return "redirect:cart.do";
    }
}
