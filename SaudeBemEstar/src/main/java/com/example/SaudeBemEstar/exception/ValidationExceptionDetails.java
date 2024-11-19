package com.example.SaudeBemEstar.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class ValidationExceptionDetails extends ExceptionDetails {
    private final String campos;  // Campos inválidos
    private final String mensagens;  // Mensagens de erro para os campos
}
