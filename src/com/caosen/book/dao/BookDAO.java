package com.caosen.book.dao;

import com.caosen.book.pojo.Book;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/18 14:56
 * @Version 1.0
 */
public interface BookDAO {
    List<Book> getBookList();
    Book getBook(Integer id);
}
