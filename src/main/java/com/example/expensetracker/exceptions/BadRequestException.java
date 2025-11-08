package com.example.expensetracker.exceptions;

import org.springframework.http.HttpStatus;

public class BadRequestException extends AppException {
    public BadRequestException(String msg, HttpStatus status) {
        super(msg, status);
    }
}
