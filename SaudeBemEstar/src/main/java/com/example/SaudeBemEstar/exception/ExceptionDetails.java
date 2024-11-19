package com.example.SaudeBemEstar.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@Getter
@SuperBuilder
public class ExceptionDetails {
    private final String titulo;
    private final int status;
    private final String detalhes;
    private final String mensagemDesenvolvedor;
    private final LocalDateTime timestamp;
}
