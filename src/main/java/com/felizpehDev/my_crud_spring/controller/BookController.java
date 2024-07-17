package com.felizpehDev.my_crud_spring.controller;

import com.felizpehDev.my_crud_spring.model.Book;
import com.felizpehDev.my_crud_spring.services.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/books/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Long id) {
        Book book = bookService.getBookById(id);
        if (book == null) {
            return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
        }

        bookService.deleteBook(id);
        return new ResponseEntity<>("Book deleted", HttpStatus.OK);
    }
}
