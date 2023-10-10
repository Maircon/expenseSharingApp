package com.expenseSharingApp.expenseSharingApp.services;

import com.expenseSharingApp.expenseSharingApp.dtos.CreateExpenseDTO;
import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import com.expenseSharingApp.expenseSharingApp.entities.ExpenseConfig;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseConfigRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ExpenseService {
    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    ExpenseConfigRepository expenseConfigRepository;

    @Autowired
    UserRepository userRepository;

    public Expense create (CreateExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setValue(expenseDTO.value());
        expense.setCreatedAt(LocalDateTime.now());
        expenseRepository.save(expense);

        expenseDTO.expensesByUser().forEach(user -> {
            ExpenseConfig expenseConfig = new ExpenseConfig();
            expenseConfig.setUser(userRepository.findById(user.idUser()).orElseThrow());
            expenseConfig.setExpense(expense);
            expenseConfig.setPercent(BigDecimal.valueOf(user.percent()));
            expenseConfigRepository.save(expenseConfig);
        });

        return expense;
    }

    public List<ExpenseConfig> getExpenses(String idUser) {
        var user = userRepository.findById(idUser).orElseThrow();
        return expenseConfigRepository.findByUser(user);
    }
}
