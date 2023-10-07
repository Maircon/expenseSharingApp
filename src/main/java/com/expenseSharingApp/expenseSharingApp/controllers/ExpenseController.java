package com.expenseSharingApp.expenseSharingApp.controllers;

import com.expenseSharingApp.expenseSharingApp.dtos.CreateExpenseDTO;
import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import com.expenseSharingApp.expenseSharingApp.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expenseService;

    @PostMapping
    public ResponseEntity<Expense> create(@RequestBody CreateExpenseDTO expenseDTO) {
        Expense expense = expenseService.create(expenseDTO);
        return new ResponseEntity<>(expense, HttpStatus.CREATED);
    }
}
