package com.expenseSharingApp.expenseSharingApp.controllers;

import com.expenseSharingApp.expenseSharingApp.dtos.CreateExpenseDTO;
import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import com.expenseSharingApp.expenseSharingApp.entities.ExpenseUser;
import com.expenseSharingApp.expenseSharingApp.services.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping
    public ResponseEntity<List<ExpenseUser>> getExpenses(@RequestParam String idUser) {
        return new ResponseEntity<>(expenseService.getExpenses(idUser), HttpStatus.OK);
    }
}
