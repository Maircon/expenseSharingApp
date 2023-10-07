package com.expenseSharingApp.expenseSharingApp.repositories;

import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseRepository extends JpaRepository<Expense, String> {
}