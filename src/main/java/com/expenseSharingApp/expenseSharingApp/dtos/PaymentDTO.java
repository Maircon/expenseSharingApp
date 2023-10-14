package com.expenseSharingApp.expenseSharingApp.dtos;

import java.math.BigDecimal;

public record PaymentDTO(BigDecimal value, String idUser, String idExpense, String idPaymentType) {
}
