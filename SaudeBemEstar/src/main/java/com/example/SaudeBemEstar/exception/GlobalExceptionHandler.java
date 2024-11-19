package com.example.SaudeBemEstar.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationExceptionDetails> handleValidationException(MethodArgumentNotValidException ex) {
        var campos = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getField())
                .collect(Collectors.joining(", "));

        var mensagens = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(fieldError -> fieldError.getDefaultMessage())
                .collect(Collectors.joining(", "));

        ValidationExceptionDetails exceptionDetails = ValidationExceptionDetails.builder()
                .titulo("Erro de Validação dos Campos")
                .status(HttpStatus.BAD_REQUEST.value())
                .detalhes("Verifique os campos com erro")
                .mensagemDesenvolvedor("Erro na validação dos dados enviados")
                .timestamp(LocalDateTime.now())
                .campos(campos)
                .mensagens(mensagens)
                .build();

        return new ResponseEntity<>(exceptionDetails, HttpStatus.BAD_REQUEST);
    }
}
