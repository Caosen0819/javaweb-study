package com.caosen.book.dao.impl;

import com.caosen.book.dao.BaseDAO;
import com.caosen.book.dao.OrderItemDAO;
import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.OrderItem;

import java.sql.SQLException;

/**
 * @Author Caosen
 * @Date 2022/7/20 19:49
 * @Version 1.0
 */
public class OrderItemDAOImpl extends BaseDAO<OrderItem> implements OrderItemDAO {
    @Override
    public void addOrderItem(OrderItem orderItem) {
//        try {
//            update("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId());
//            System.out.println("updateitem");
//        } catch (SQLException e) {
//            throw  new RuntimeException(e);
//        }
        super.executeUpdate("insert into t_order_item values(0,?,?,?)",orderItem.getBook().getId(),orderItem.getBuyCount(),orderItem.getOrderBean().getId()) ;


    }
}
