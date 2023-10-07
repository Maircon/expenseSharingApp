package com.expenseSharingApp.expenseSharingApp.repositories;

import com.expenseSharingApp.expenseSharingApp.entities.ExpenseConfig;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExpenseConfigRepository extends JpaRepository<ExpenseConfig, String> {
}
