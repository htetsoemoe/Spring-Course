package com.example.demospringrest1.exception;

import org.springframework.validation.FieldError;

import java.util.ArrayList;
import java.util.List;

public class ValidationErrorDTO {

    private final List<FieldErrorDTO> fieldsErrors = new ArrayList<>();

    public final void addFieldError(final String path, final String message) {
        final FieldErrorDTO error = new FieldErrorDTO(path, message);
        fieldsErrors.add(error);
    }

    public List<FieldErrorDTO> getFieldsErrors() {
        return fieldsErrors;
    }

    public final String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ValidationErrorDTO [fieldsErrors] = ")
                .append(fieldsErrors).append(" ]");
        return builder.toString();
    }
}
