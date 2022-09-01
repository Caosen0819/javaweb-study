package com.caosen.book.dao;


import com.caosen.book.pojo.OrderBean;
import com.caosen.book.pojo.User;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/20 19:44
 * @Version 1.0
 */
public interface OrderDAO {
    void addOrder(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
    Integer getOrderTotalBookCount(OrderBean orderBean);
}
