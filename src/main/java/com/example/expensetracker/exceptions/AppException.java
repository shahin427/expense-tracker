package com.example.expensetracker.exceptions;

import lombok.Data;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AppException extends RuntimeException{
    private final HttpStatus status;

    public AppException(String msg, HttpStatus status) {
              super(msg);
              this.status = status;
    }

}
