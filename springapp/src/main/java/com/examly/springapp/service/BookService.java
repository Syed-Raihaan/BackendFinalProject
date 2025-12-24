package com.examly.springapp.service;

import com.examly.springapp.model.Book;
import com.examly.springapp.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book saveBook(Book book) {
        return bookRepo.save(book);
    }

    public List<Book> getAllBooks() {
        return bookRepo.findAll();
    }

    public Book getBookById(Integer id) {
        return bookRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book not found"));
    }

    public Book updateBook(Integer id, Book book) {
        Book existing = getBookById(id);
        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setAvailable(book.getAvailable());
        existing.setBookCategory(book.getBookCategory());
        return bookRepo.save(existing);
    }

    public void deleteBook(Integer id) {
        bookRepo.deleteById(id);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepo.findByTitle(title);
    }

    public List<Book> getBooksByCategoryName(String categoryName) {
        return bookRepo.findByBookCategoryCategoryName(categoryName);
    }
}