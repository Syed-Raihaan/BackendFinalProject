package com.examly.springapp.service;

import com.examly.springapp.model.BookCategory;
import com.examly.springapp.repository.BookCategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class BookCategoryService {

    @Autowired
    private BookCategoryRepo bookCategoryRepo;

    public BookCategory saveBookCategory(BookCategory bookCategory) {
        return bookCategoryRepo.save(bookCategory);
    }

    public List<BookCategory> getAllBookCategories() {
        return bookCategoryRepo.findAll();
    }

    public BookCategory getBookCategoryById(Long id) {
        return bookCategoryRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Book category not found"));
    }

    public BookCategory updateBookCategory(Long id, BookCategory bookCategory) {
        BookCategory existing = getBookCategoryById(id);
        existing.setCategoryName(bookCategory.getCategoryName());
        return bookCategoryRepo.save(existing);
    }

    public void deleteBookCategory(Long id) {
        bookCategoryRepo.deleteById(id);
    }

    public Page<BookCategory> getCategoriesWithPagination(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        return bookCategoryRepo.findAll(pageable);
    }
}