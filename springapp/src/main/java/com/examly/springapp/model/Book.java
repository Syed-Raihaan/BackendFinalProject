package com.examly.springapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bookId;
    private String title;
    private String author;
    private Boolean available;
    @ManyToOne
    private BookCategory bookCategory;

    public int getBookId() {
        return bookId;
    }
    public void setBookId(int bookId) {
        this.bookId = bookId;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public Boolean getAvailable() {
        return available;
    }
    public void setAvailable(Boolean available) {
        this.available = available;
    }
    public BookCategory getBookCategory() {
        return bookCategory;
    }
    public void setBookCategory(BookCategory bookCategory) {
        this.bookCategory = bookCategory;
    }
}
