package com.caosen.book.pojo;

import java.util.Map;
import java.util.Set;

/**
 * @Author Caosen
 * @Date 2022/7/19 11:49
 * @Version 1.0
 */
public class Cart {
    private Map<Integer, CartItem> cartItemMap;
    private Double totalMoney;
    private Integer totalCount;
    private Integer totalBookCount;

    public void settotalBookCount(Integer totalBookCount) {
        this.totalBookCount = totalBookCount;
    }



    public Integer getTotalBookCount() {
        totalBookCount = 0;
        if(cartItemMap != null && cartItemMap.size()>0){
            for(CartItem cartItem :cartItemMap.values()){
                totalBookCount += cartItem.getBuyCount() ;
            }
        }
        return totalBookCount;
    }

    public Map<Integer, CartItem> getCartItemMap() {
        return cartItemMap;
    }

    public void setCartItemMap(Map<Integer, CartItem> cartItemMap) {
        this.cartItemMap = cartItemMap;
    }

    public Double getTotalMoney() {

        totalMoney = 0.0;
        if (cartItemMap != null && cartItemMap.size() > 0){
            Set<Map.Entry<Integer, CartItem>> entries = cartItemMap.entrySet();
            for (Map.Entry<Integer, CartItem> cartItementry: entries
                 ) {
                CartItem cartItementryValue = cartItementry.getValue();
                totalMoney += cartItementryValue.getBook().getPrice() * cartItementryValue.getBuyCount();
            }
        }

        return totalMoney;
    }

    public void setTotalMoney(Double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Integer getTotalCount() {
        totalCount = 0;
        if (cartItemMap != null && cartItemMap.size() > 0){
            totalCount = cartItemMap.size();
        }
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
