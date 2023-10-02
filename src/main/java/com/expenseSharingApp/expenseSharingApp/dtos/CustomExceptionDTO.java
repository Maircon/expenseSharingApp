package com.expenseSharingApp.expenseSharingApp.dtos;

import java.time.LocalDateTime;

public record CustomExceptionDTO(String message, String code, LocalDateTime timeStamp) {
  
}
