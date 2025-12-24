package com.examly.springapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.examly.springapp.model.BookCategory;
import com.examly.springapp.service.BookCategoryService;
import java.util.List;

@RestController
@RequestMapping("/api/book-categories")
public class BookCategoryController {

    @Autowired
    private BookCategoryService bookCategoryService;

    @PostMapping
    public ResponseEntity<BookCategory> createCategory(@RequestBody BookCategory bookCategory) {
        BookCategory saved = bookCategoryService.saveBookCategory(bookCategory);
        return new ResponseEntity<>(saved, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<BookCategory>> getAllCategories() {
        List<BookCategory> categories = bookCategoryService.getAllBookCategories();
        if (categories.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getCategoryById(@PathVariable Long id) {
        try {
            BookCategory category = bookCategoryService.getBookCategoryById(id);
            return new ResponseEntity<>(category, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Book category not found");
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookCategory> updateCategory(@PathVariable Long id, @RequestBody BookCategory bookCategory) {
        BookCategory updated = bookCategoryService.updateBookCategory(id, bookCategory);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        bookCategoryService.deleteBookCategory(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/page/{page}/{size}")
    public ResponseEntity<Page<BookCategory>> getCategoriesWithPagination(@PathVariable int page, @PathVariable int size) {
        Page<BookCategory> categories = bookCategoryService.getCategoriesWithPagination(page, size);
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}