package com.expenseSharingApp.expenseSharingApp.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity(name = "payment")
@Table(name = "payment")
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id_payment")
    private String id;

    @Column(name = "value")
    private BigDecimal value;

    @Column(name = "payment_at")
    private LocalDateTime paymentAt;

    @ManyToOne
    @JoinColumn(name = "id_payment_type", referencedColumnName = "id_payment_type")
    private PaymentType paymentType;

    @ManyToOne
    @JoinColumn(name = "id_expense", referencedColumnName = "id_expense")
    private Expense expense;
}
