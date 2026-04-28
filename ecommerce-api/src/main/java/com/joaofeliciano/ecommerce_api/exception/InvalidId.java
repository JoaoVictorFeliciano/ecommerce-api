package com.joaofeliciano.ecommerce_api.exception;

public class InvalidId extends RuntimeException {
    public InvalidId(String message) {
        super(message);
    }
}
