package org.example.exception;

public class ProductMustBeUniqueException extends RuntimeException {
    public ProductMustBeUniqueException(String message) {
        super(message);
    }
}
