package com.joaofeliciano.ecommerce_api.exception;

public class InvalidCart extends RuntimeException {
    public InvalidCart(String message) {
        super(message);
    }
}
