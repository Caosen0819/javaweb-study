package com.caosen.book.service;

import com.caosen.book.pojo.Cart;
import com.caosen.book.pojo.User;

/**
 * @Author Caosen
 * @Date 2022/7/18 13:04
 * @Version 1.0
 */
public interface UserService {
    User login(String uname, String pwd);
    void regist(User user);
    User getUser(String uname);
}
