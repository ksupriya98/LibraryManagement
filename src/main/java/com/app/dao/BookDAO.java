package com.app.dao;

import java.util.List;
import com.app.entity.Book;

public interface BookDAO {
    List<Book> getBooks();
    void saveBook(Book book);
}