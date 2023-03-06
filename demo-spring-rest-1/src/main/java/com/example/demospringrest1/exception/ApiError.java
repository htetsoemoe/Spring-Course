package com.example.demospringrest1.exception;

import java.util.Objects;

public class ApiError {

    private int status;
    private String message;
    private String developerMessage;

    public ApiError(int status, String message, String developerMessage) {
        this.status = status;
        this.message = message;
        this.developerMessage = developerMessage;
    }

    public int getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ApiError apiError = (ApiError) o;
        return getStatus() == apiError.getStatus() && Objects.equals(getMessage(), apiError.getMessage()) && Objects.equals(getDeveloperMessage(), apiError.getDeveloperMessage());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStatus(), getMessage(), getDeveloperMessage());
    }

    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("ApiError [status = ")
                .append(status)
                .append(", message = ")
                .append(message)
                .append(", developerMessage = ")
                .append(developerMessage)
                .append(" ]");
        return builder.toString();
    }
}
