package com.expenseSharingApp.expenseSharingApp.services;

import com.expenseSharingApp.expenseSharingApp.dtos.PaymentDTO;
import com.expenseSharingApp.expenseSharingApp.entities.*;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseConfigRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseConfigRepository expenseConfigRepository;

    public Payment pay (PaymentDTO pay) {
        Expense expense = expenseRepository.findById(pay.idExpense()).orElseThrow();
        PaymentType paymentType = new PaymentType();
        paymentType.setId(pay.idPaymentType());

        Payment payment = new Payment();
        payment.setPaymentAt(LocalDateTime.now());
        payment.setValue(pay.value());
        payment.setPaymentType(paymentType);
        payment.setExpense(expense);
        return this.paymentRepository.save(payment);
    }

    public List<Payment> listPayments (String idUser) {
        User user = new User();
        user.setId(idUser);
        List<ExpenseConfig> expenseConfigList = expenseConfigRepository.findByUser(user);
        List<Expense> expenseList = expenseConfigList.stream().map(ExpenseConfig::getExpense).toList();
        return paymentRepository.findByExpenseIn(expenseList);
    }
}
