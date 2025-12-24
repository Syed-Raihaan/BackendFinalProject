package com.examly.springapp.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/borrows")
public class BorrowController {

    @PostMapping
    public void createBorrow() {}

    @GetMapping
    public void getAllBorrows() {}

    @GetMapping("/{id}")
    public void getBorrowById(@PathVariable Long id) {}

    @PutMapping("/{id}")
    public void updateBorrow(@PathVariable Long id) {}
}