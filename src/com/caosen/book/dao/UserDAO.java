package com.caosen.book.dao;

import com.caosen.book.pojo.User;

/**
 * @Author Caosen
 * @Date 2022/7/18 12:52
 * @Version 1.0
 */
public interface UserDAO {
    public User getUser(String uname, String pwd);
    public void addUser(User user);
    User getUser(String uname);
}
