package com.expenseSharingApp.expenseSharingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "expenses")
@Table(name = "expenses")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_expense")
    private String id;

    @Column(name = "expense_value")
    private BigDecimal value;

    @Column(name = "created_at")
    private LocalDateTime createdAt;
}
