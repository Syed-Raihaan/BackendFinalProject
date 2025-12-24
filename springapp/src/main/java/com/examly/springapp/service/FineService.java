package com.examly.springapp.service;

import com.examly.springapp.model.Fine;
import com.examly.springapp.repository.FineRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
public class FineService {

    @Autowired
    private FineRepo fineRepo;

    public Fine saveFine(Fine fine) {
        return fineRepo.save(fine);
    }

    public List<Fine> getAllFines() {
        return fineRepo.findAll();
    }

    public Fine getFineById(Long id) {
        return fineRepo.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Fine not found"));
    }

    public Fine updateFine(Long id, Fine fine) {
        Fine existing = getFineById(id);
        existing.setAmount(fine.getAmount());
        existing.setBorrow(fine.getBorrow());
        return fineRepo.save(existing);
    }

    public void deleteFine(Long id) {
        fineRepo.deleteById(id);
    }
}