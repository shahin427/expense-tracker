package com.example.expensetracker.exceptions;

import org.springframework.http.HttpStatus;

public class AppException extends RuntimeException{
    private HttpStatus status;

    public AppException(String msg, HttpStatus status) {
              super(msg);
              this.status = status;
    }
}
