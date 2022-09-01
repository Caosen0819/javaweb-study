package com.caosen.book.pojo;

import com.sun.source.tree.LambdaExpressionTree;

/**
 * @Author Caosen
 * @Date 2022/7/18 11:23
 * @Version 1.0
 */
public class OrderItem {
    private Integer id ;
    private Book book ;
    private Integer buyCount ;
    private OrderBean orderBean ;
    public OrderItem(){

    }

    public OrderItem(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Integer getBuyCount() {
        return buyCount;
    }

    public void setBuyCount(Integer buyCount) {
        this.buyCount = buyCount;
    }

    public OrderBean getOrderBean() {
        return orderBean;
    }

    public void setOrderBean(OrderBean orderBean) {
        this.orderBean = orderBean;
    }
}
