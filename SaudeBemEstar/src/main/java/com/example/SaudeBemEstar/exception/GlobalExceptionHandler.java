package com.example.SaudeBemEstar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<ExceptionDetails> handleBadRequestException(BadRequestException ex) {
        ExceptionDetails details = ExceptionDetails.builder()
                .title("Bad Request")
                .status(HttpStatus.BAD_REQUEST.value())
                .details(ex.getMessage())
                .developerMessage(ex.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDetails> handleNotFoundException(NotFoundException ex) {
        ExceptionDetails details = ExceptionDetails.builder()
                .title("Resource Not Found")
                .status(HttpStatus.NOT_FOUND.value())
                .details(ex.getMessage())
                .developerMessage(ex.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(details, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<ExceptionDetails> handleValidationException(ValidationException ex) {
        ExceptionDetails details = ExceptionDetails.builder()
                .title("Validation Error")
                .status(HttpStatus.BAD_REQUEST.value())
                .details(ex.getMessage())
                .developerMessage(ex.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDetails> handleGlobalException(Exception ex) {
        ExceptionDetails details = ExceptionDetails.builder()
                .title("Internal Server Error")
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .details(ex.getMessage())
                .developerMessage(ex.toString())
                .timestamp(LocalDateTime.now())
                .build();
        return new ResponseEntity<>(details, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}