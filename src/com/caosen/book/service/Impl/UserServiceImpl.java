package com.caosen.book.service.Impl;

import com.caosen.book.dao.UserDAO;
import com.caosen.book.pojo.User;

/**
 * @Author Caosen
 * @Date 2022/7/18 13:05
 * @Version 1.0
 */
public class UserServiceImpl implements com.caosen.book.service.UserService {

    private UserDAO userDAO;
    @Override
    public User login(String uname, String pwd) {
        return userDAO.getUser(uname, pwd);
    }

    @Override
    public void regist(User user) {
        userDAO.addUser(user);
    }

    @Override
    public User getUser(String uname) {
        return userDAO.getUser(uname);
    }
}
