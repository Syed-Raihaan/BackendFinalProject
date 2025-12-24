package com.examly.springapp.service;

import com.examly.springapp.model.Borrow;
import com.examly.springapp.repository.BorrowRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepo borrowRepo;

    public Borrow saveBorrow(Borrow borrow) {
        return borrowRepo.save(borrow);
    }

    public List<Borrow> getAllBorrows() {
        return borrowRepo.findAll();
    }

    public Borrow getBorrowById(Long id) {
        return borrowRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Borrow not found"));
    }

    public Borrow updateBorrow(Long id, Borrow borrow) {
        Borrow existing = getBorrowById(id);
        existing.setBook(borrow.getBook());
        existing.setMember(borrow.getMember());
        existing.setBorrowDate(borrow.getBorrowDate());
        existing.setReturnDate(borrow.getReturnDate());
        return borrowRepo.save(existing);
    }

    public void deleteBorrow(Long id) {
        borrowRepo.deleteById(id);
    }
}