package com.example.demo.exception;

public class CustomGraphQLException extends RuntimeException {
    public CustomGraphQLException(String message) {
        super(message);
    }
}
