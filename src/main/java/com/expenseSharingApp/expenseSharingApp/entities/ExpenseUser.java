package com.expenseSharingApp.expenseSharingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity(name = "expense_users")
@Table(name = "expense_users")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class ExpenseUser {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_expense_user")
    private String id;

    @ManyToOne
    @JoinColumn(name = "id_expense", referencedColumnName = "id_expense")
    private Expense expense;

    @ManyToOne
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    private User user;

//    @Column(name = "id_user")
//    private String idUser;

    @Column(name = "percent")
    private BigDecimal percent;
}
