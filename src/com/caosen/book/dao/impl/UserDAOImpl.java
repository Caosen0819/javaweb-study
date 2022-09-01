package com.caosen.book.dao.impl;

import com.caosen.book.dao.BaseDAO;
import com.caosen.book.dao.UserDAO;
import com.caosen.book.pojo.User;

/**
 * @Author Caosen
 * @Date 2022/7/18 12:53
 * @Version 1.0
 */
public class UserDAOImpl extends BaseDAO<User> implements UserDAO {

    @Override
    public User getUser(String uname, String pwd) {
        return (User) querySingle("select * from t_user where uname = ? and pwd = ?", User.class, uname, pwd);
    }

    @Override
    public void addUser(User user) {
         executeUpdate("insert into t_user values(0, ?, ?, ?, 0)", user.getUname(), user.getPwd(), user.getEmail());

    }

    @Override
    public User getUser(String uname) {
        return load("select * from t_user where uname = ?", uname);
    }


}
