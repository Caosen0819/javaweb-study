package com.caosen.book.service.Impl;

import com.caosen.book.dao.CartItemDAO;
import com.caosen.book.dao.OrderDAO;
import com.caosen.book.dao.OrderItemDAO;
import com.caosen.book.pojo.CartItem;
import com.caosen.book.pojo.OrderBean;
import com.caosen.book.pojo.OrderItem;
import com.caosen.book.pojo.User;
import com.caosen.book.service.OrderService;

import java.util.List;
import java.util.Map;

/**
 * @Author Caosen
 * @Date 2022/7/20 19:58
 * @Version 1.0
 */
public class OrderServiceImpl implements OrderService {

    private OrderDAO orderDAO;
    private OrderItemDAO orderItemDAO;
    private CartItemDAO cartItemDAO;
    @Override
    public void addOrderBean(OrderBean orderBean) {
        //增加一条订单
        orderDAO.addOrder(orderBean);
        //增加七条详情
        User currUser = orderBean.getOrderUser();
        Map<Integer, CartItem> cartItemMap = currUser.getCart().getCartItemMap();
        for (CartItem cartItem : cartItemMap.values()) {
            OrderItem orderItem = new OrderItem();
            orderItem.setBook(cartItem.getBook());
            orderItem.setBuyCount(cartItem.getBuyCount());
            orderItem.setOrderBean(orderBean);
            orderItemDAO.addOrderItem(orderItem);

        }
//        List<OrderItem> orderItemsList = orderBean.getOrderItemsList();
//        for (OrderItem orderItem: orderItemsList
//             ) {
//            orderItemDAO.addOrderItem(orderItem);
//        }
        //删除购物车记录

        for (CartItem cartItem : cartItemMap.values()) {
            cartItemDAO.deCartItem(cartItem);
        }

    }

    @Override
    public List<OrderBean> getOrderList(User user) {

        List<OrderBean> orderList = orderDAO.getOrderList(user);
        for(OrderBean orderBean: orderList){
            Integer totalBookCount = orderDAO.getOrderTotalBookCount(orderBean);
            orderBean.setTotalBookCount(totalBookCount);
        }
        return orderList;
    }
}
