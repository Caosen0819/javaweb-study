package com.caosen.book.Controller;

import com.caosen.book.pojo.OrderBean;
import com.caosen.book.pojo.User;
import com.caosen.book.service.OrderService;

import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Author Caosen
 * @Date 2022/7/20 20:17
 * @Version 1.0
 */
public class OrderController {

    private OrderService orderService;

    public String checkout(HttpSession session){

        OrderBean orderBean = new OrderBean();
        Date date = new Date();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String nowStr = simpleDateFormat.format(date);
        orderBean.setOrderNo(UUID.randomUUID().toString() + nowStr);
        orderBean.setOrderDate(date);

        User user = (User) session.getAttribute("currUser");
        orderBean.setOrderUser(user);
        orderBean.setOrderMoney(user.getCart().getTotalMoney());
        orderBean.setOrderStatus(0);

        orderService.addOrderBean(orderBean);

        return "index";
    }

    public String getOrderList(HttpSession session){
        User currUser =(User) session.getAttribute("currUser");
        List<OrderBean> orderList = orderService.getOrderList(currUser);
        currUser.setOrderList(orderList);
        session.setAttribute("currUser",currUser);
        return "order/order";
//        User user =(User)session.getAttribute("currUser");
//
//        List<OrderBean> orderList = orderService.getOrderList(user);
//        user.setOrderList(orderList);
//
//        session.setAttribute("currUser",user);
//
//        return "order/order" ;
    }
}
