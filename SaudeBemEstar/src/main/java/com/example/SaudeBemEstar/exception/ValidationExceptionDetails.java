package com.example.SaudeBemEstar.exception;

import lombok.Builder;

@Builder
public class ValidationExceptionDetails extends ExceptionDetails {
    private String fields;
    private String fieldsMessage;
}