package com.caosen.book.Controller;

import com.caosen.book.pojo.Book;
import com.caosen.book.service.BookService;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author Caosen
 * @Date 2022/7/18 15:11
 * @Version 1.0
 */
public class BookController {

    private BookService bookService;
    public String index(HttpSession session){
        List<Book> bookList = bookService.getBookList();
        System.out.println("booklist = " + bookList);
        session.setAttribute("bookList", bookList);
        return "index";
    }
}
