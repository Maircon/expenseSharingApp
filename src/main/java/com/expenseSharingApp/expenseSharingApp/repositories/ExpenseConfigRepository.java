package com.expenseSharingApp.expenseSharingApp.repositories;

import com.expenseSharingApp.expenseSharingApp.entities.ExpenseConfig;
import com.expenseSharingApp.expenseSharingApp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseConfigRepository extends JpaRepository<ExpenseConfig, String> {
    public List<ExpenseConfig> findByUser(User user);
}
