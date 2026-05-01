package com.joaofeliciano.ecommerce_api.exception;

public class InvalidCategory extends RuntimeException {
    public InvalidCategory(String message) {
        super(message);
    }
}
