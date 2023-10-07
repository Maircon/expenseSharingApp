package com.expenseSharingApp.expenseSharingApp.dtos;

import java.math.BigDecimal;

public record TransactionCreateInputDTO(String idReceiver, String idSender, BigDecimal value) {
}
