package com.example.SaudeBemEstar.exception;

import lombok.Getter;
import lombok.experimental.SuperBuilder;

@Getter
@SuperBuilder
public class BadRequestExceptionDetails extends ExceptionDetails {
    // Não é necessário adicionar campos extras, mas eles podem ser incluídos se necessário.
}
