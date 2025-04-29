package org.example.exception;

public class PaymentAlreadyCancelledException extends RuntimeException {
    public PaymentAlreadyCancelledException(String message) {
        super(message);
    }


}