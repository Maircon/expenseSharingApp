package com.expenseSharingApp.expenseSharingApp.infra;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.expenseSharingApp.expenseSharingApp.dtos.CustomExceptionDTO;

@ControllerAdvice
public class RestControllerErrorHandler {
  @ExceptionHandler(Exception.class)
  public ResponseEntity<CustomExceptionDTO> InternalServerError(Exception exception) {
    CustomExceptionDTO customExceptionDTO = new CustomExceptionDTO(exception.getMessage(), "500", LocalDateTime.now());
    return new ResponseEntity<>(customExceptionDTO, HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
