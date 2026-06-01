package com.app.service;

import java.util.List;
import com.app.entity.Book;

public interface BookService {
    List<Book> getBooks();
    void saveBook(Book book);
}