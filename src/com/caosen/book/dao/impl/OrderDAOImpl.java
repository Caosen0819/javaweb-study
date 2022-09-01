package com.caosen.book.dao.impl;

import com.caosen.book.dao.BaseDAO;
import com.caosen.book.dao.OrderDAO;
import com.caosen.book.pojo.OrderBean;
import com.caosen.book.pojo.User;

import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/20 19:48
 * @Version 1.0
 */
public class OrderDAOImpl extends BaseDAO<OrderBean> implements OrderDAO {

    @Override
    public void addOrder(OrderBean orderBean) {

        int orderBeanId = super.executeUpdate("insert into t_order values(0,?,?,?,?,?)",orderBean.getOrderNo(),orderBean.getOrderDate(),orderBean.getOrderUser().getId(),orderBean.getOrderMoney(),orderBean.getOrderStatus());
        orderBean.setId(orderBeanId);


    }

    @Override
    public List<OrderBean> getOrderList(User user) {
        return executeQuery("select * from t_order where orderUser = ?", user.getId());
    }

    @Override
    public Integer getOrderTotalBookCount(OrderBean orderBean) {
        String sql = "SELECT SUM(t3.buyCount) AS totalBookCount , t3.orderBean FROM " +
                "(" +
                "SELECT t1.id , t2.buyCount , t2.orderBean FROM t_order t1 INNER JOIN t_order_item t2 " +
                "ON t1.id = t2.orderBean WHERE t1.orderUser = ? " +
                ") t3 WHERE t3.orderBean = ? GROUP BY t3.orderBean" ;
        return ((BigDecimal)executeComplexQuery(sql,orderBean.getOrderUser().getId(),orderBean.getId())[0]).intValue();
    }
}
