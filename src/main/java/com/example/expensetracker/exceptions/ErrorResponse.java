package com.example.expensetracker.exceptions;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Builder
@Data
public class ErrorResponse {
    private LocalDateTime errorTime;
    private HttpStatus status;
    private String message;
    private String error;
}
