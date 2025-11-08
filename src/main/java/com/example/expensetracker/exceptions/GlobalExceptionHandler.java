package com.example.expensetracker.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AppException.class)
    public ResponseEntity<ErrorResponse> handleAppException(AppException ex) {
        ErrorResponse error = ErrorResponse.builder()
                .errorTime(LocalDateTime.now())
                .status(ex.getStatus())
                .error("app error")
                .message(ex.getMessage())
                .build();
        return new ResponseEntity<>(error,ex.getStatus());
    }
}
