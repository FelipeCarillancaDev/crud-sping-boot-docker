package com.felizpehDev.my_crud_spring.controller;

import com.felizpehDev.my_crud_spring.model.Book;
import com.felizpehDev.my_crud_spring.services.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {

    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @PostMapping("/books")
    public long createBook(@RequestBody Book book) {
         return bookService.createBook(book);
    }
}
