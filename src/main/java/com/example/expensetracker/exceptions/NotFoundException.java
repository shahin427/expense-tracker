package com.example.expensetracker.exceptions;

import org.springframework.http.HttpStatus;

public class NotFoundException extends AppException {

    public NotFoundException(String msg, HttpStatus status) {
        super(msg, status);
    }
}
