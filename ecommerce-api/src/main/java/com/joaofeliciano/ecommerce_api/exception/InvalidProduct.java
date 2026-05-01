package com.joaofeliciano.ecommerce_api.exception;

public class InvalidProduct extends RuntimeException {
    public InvalidProduct(String message) {
        super(message);
    }
}
