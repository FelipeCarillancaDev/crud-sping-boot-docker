package com.felizpehDev.my_crud_spring.services;

import com.felizpehDev.my_crud_spring.model.Book;
import com.felizpehDev.my_crud_spring.repositories.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.getAllBooks();
    }

    public long createBook(Book newBook) {
        return bookRepository.createBook(newBook);
    }

    public Book getBookById(long id) {
        return bookRepository.getBookById(id);
    }

    public void deleteBook(Long id) {
        bookRepository.deleteBook(id);
    }
}
