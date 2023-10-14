package com.expenseSharingApp.expenseSharingApp.repositories;

import com.expenseSharingApp.expenseSharingApp.entities.Expense;
import com.expenseSharingApp.expenseSharingApp.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, String> {
    List<Payment> findByExpenseIn(List<Expense> expenseList);
}
