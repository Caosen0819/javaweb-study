package com.caosen.book.service;

import com.caosen.book.pojo.Book;

import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/18 15:05
 * @Version 1.0
 */
public interface BookService {
    List<Book> getBookList();
    Book getBook(Integer id);
}
