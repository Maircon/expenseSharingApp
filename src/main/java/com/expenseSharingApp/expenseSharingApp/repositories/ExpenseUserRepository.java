package com.expenseSharingApp.expenseSharingApp.repositories;

import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import com.expenseSharingApp.expenseSharingApp.entities.ExpenseUser;
import com.expenseSharingApp.expenseSharingApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseUserRepository extends JpaRepository<ExpenseUser, String> {
    List<ExpenseUser> findByUser(User user);
    ExpenseUser findByUserAndExpense(User user, Expense expense);
}
