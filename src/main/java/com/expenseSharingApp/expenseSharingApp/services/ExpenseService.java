package com.expenseSharingApp.expenseSharingApp.services;

import com.expenseSharingApp.expenseSharingApp.dtos.CreateExpenseDTO;
import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import com.expenseSharingApp.expenseSharingApp.entities.ExpenseUser;
import com.expenseSharingApp.expenseSharingApp.repositories.UserRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseUserRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseRepository;
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
    ExpenseUserRepository expenseUserRepository;

    @Autowired
    UserRepository userRepository;

    public Expense create (CreateExpenseDTO expenseDTO) {
        Expense expense = new Expense();
        expense.setValue(expenseDTO.value());
        expense.setCreatedAt(LocalDateTime.now());
        expenseRepository.save(expense);

        expenseDTO.expensesByUser().forEach(user -> {
            ExpenseUser expenseUser = new ExpenseUser();
            expenseUser.setUser(userRepository.findById(user.idUser()).orElseThrow());
            expenseUser.setExpense(expense);
            expenseUser.setPercent(BigDecimal.valueOf(user.percent()));
            expenseUserRepository.save(expenseUser);
        });

        return expense;
    }

    public List<ExpenseUser> getExpenses(String idUser) {
        var user = userRepository.findById(idUser).orElseThrow();
        return expenseUserRepository.findByUser(user);
    }
}
