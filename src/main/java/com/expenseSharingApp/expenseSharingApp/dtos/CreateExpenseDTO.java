package com.expenseSharingApp.expenseSharingApp.dtos;

import java.math.BigDecimal;
import java.util.ArrayList;

public record CreateExpenseDTO(BigDecimal value, ArrayList<ExpenseConfigDTO> expensesByUser) {
}
