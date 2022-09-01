package com.caosen.book.dao.impl;

import com.caosen.book.dao.BaseDAO;
import com.caosen.book.dao.BookDAO;
import com.caosen.book.pojo.Book;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/18 14:59
 * @Version 1.0
 */
public class BookDAOImpl extends BaseDAO<Book> implements BookDAO {
    @Override
    public List<Book> getBookList() {
        return queryMutiple("select * from t_book where bookStatus = 0", Book.class);
    }

    @Override
    public Book getBook(Integer id) {
        return querySingle("select * from t_book where id = ?", Book.class, id);
    }
}
