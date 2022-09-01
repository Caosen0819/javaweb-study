package com.caosen.book.dao.impl;

import com.caosen.book.dao.BaseDAO;
import com.caosen.book.dao.CartItemDAO;
import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.User;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/19 11:18
 * @Version 1.0
 */
public class CartItemDAOImpl extends BaseDAO<CartItem> implements CartItemDAO {
    @Override
    public void addCartItem(CartItem cartItem) {
        try {
            update("insert into t_cart_item values(0, ?, ?, ?)", cartItem.getBook().getId(), cartItem.getBuyCount(), cartItem.getUserBean().getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCartItem(CartItem cartItem) {
        try {
            //Integer userid = cartItem.getUserBean().getId();
            //Integer bookid = cartItem.getBook().getId();
            //update("update t_cart_item set buyCount = ? where book = ? and userBean = ?", cartItem.getBuyCount(), bookid, userid);
            update("update t_cart_item set buyCount = ? where id = ?", cartItem.getBuyCount(), cartItem.getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<CartItem> getCartItemList(User user) {


        return executeQuery("select * from t_cart_item where userBean = ? " , user.getId());
    }

    @Override
    public void deCartItem(CartItem cartItem) {
        try {
            update("delete from t_cart_item where id = ?", cartItem.getId());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    @Override
//    public void addOrUpdateCartItem(CartItem cartItem) {
//
//    }
}
