package com.caosen.book.service.Impl;

import com.caosen.book.dao.BookDAO;
import com.caosen.book.pojo.Book;
import com.caosen.book.service.BookService;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/18 15:06
 * @Version 1.0
 */
public class BookServiceImpl implements BookService {

    private BookDAO bookDAO;
    @Override
    public List<Book> getBookList() {
        return bookDAO.getBookList();
    }

    @Override
    public Book getBook(Integer id) {
        return bookDAO.getBook(id);
    }
}
