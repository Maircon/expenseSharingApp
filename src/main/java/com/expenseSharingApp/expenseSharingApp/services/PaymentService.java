package com.expenseSharingApp.expenseSharingApp.services;

import com.expenseSharingApp.expenseSharingApp.dtos.PaymentDTO;
import com.expenseSharingApp.expenseSharingApp.entities.*;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseUserRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.ExpenseRepository;
import com.expenseSharingApp.expenseSharingApp.repositories.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ExpenseRepository expenseRepository;

    @Autowired
    private ExpenseUserRepository expenseUserRepository;

    public Boolean expenseWasPaid (BigDecimal valueToPayByUser, BigDecimal paidValueByUser) {
        return paidValueByUser.compareTo(valueToPayByUser) >= 0;
    }

    public Boolean checkIfPaymentCanBePaid(PaymentDTO payment, BigDecimal valueToBePaid) {
        return payment.value().compareTo(valueToBePaid) <= 0;
    }

    public Payment pay (PaymentDTO pay) throws Exception {
        var user = new User();
        user.setId(pay.idUser());

        Expense expense = expenseRepository.findById(pay.idExpense()).orElseThrow();
        ExpenseUser expenseUser = expenseUserRepository.findByUserAndExpense(user, expense);

        BigDecimal valueToPayByUser = expense.getValue().multiply(expenseUser.getPercent()).divide(BigDecimal.valueOf(100), RoundingMode.HALF_UP);
        BigDecimal paidValueByUser = paymentRepository
                .findByExpenseUser(expenseUser)
                .stream()
                .reduce(
                        BigDecimal.ZERO,
                        (acc, payment) -> acc.add(payment.getValue()),
                        BigDecimal::add
                );
        BigDecimal valueToBePaid = valueToPayByUser.min(paidValueByUser);

        if (this.expenseWasPaid(valueToPayByUser, paidValueByUser)) {
            throw new Exception("Expense was paid already");
        }

        if (this.checkIfPaymentCanBePaid(pay, valueToBePaid)) {
            throw new Exception("Value to pay is greater than payment");
        }

        PaymentType paymentType = new PaymentType();
        paymentType.setId(pay.idPaymentType());

        Payment payment = new Payment();
        payment.setPaymentAt(LocalDateTime.now());
        payment.setValue(pay.value());
        payment.setPaymentType(paymentType);
        payment.setExpenseUser(expenseUser);
        return this.paymentRepository.save(payment);
    }

    public List<Payment> listPayments (String idUser) {
        User user = new User();
        user.setId(idUser);
        List<ExpenseUser> expenseUserList = expenseUserRepository.findByUser(user);
        return paymentRepository.findByExpenseUserIn(expenseUserList);
    }
}
