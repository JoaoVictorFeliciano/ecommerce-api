package com.joaofeliciano.ecommerce_api.exception;

public class InvalidAddress extends RuntimeException {
    public InvalidAddress(String message) {
        super(message);
    }
}
