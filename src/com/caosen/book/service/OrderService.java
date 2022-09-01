package com.caosen.book.service;

import com.caosen.book.pojo.OrderBean;
import com.caosen.book.pojo.User;
import com.mysql.cj.x.protobuf.MysqlxCrud;


import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/20 19:58
 * @Version 1.0
 */
public interface OrderService {
    void addOrderBean(OrderBean orderBean);
    List<OrderBean> getOrderList(User user);
}
