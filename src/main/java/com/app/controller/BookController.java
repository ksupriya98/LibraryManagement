package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.entity.Book;
import com.app.service.BookService;

@Controller
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping(value = {"", "/", "/book/list"})
    public String listBooks(Model model) {
        model.addAttribute("books", bookService.getBooks());
        return "book-list";
    }

    @GetMapping("/book/showForm")
    public String showForm(Model model) {
        model.addAttribute("book", new Book());
        return "add-book";
    }

    @PostMapping("/book/save")
    public String saveBook(@ModelAttribute("book") Book book) {
        bookService.saveBook(book);
        return "redirect:/";
    }
}
