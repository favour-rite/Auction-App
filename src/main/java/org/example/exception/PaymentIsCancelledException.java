package org.example.exception;

public class PaymentIsCancelledException extends RuntimeException {
    public PaymentIsCancelledException(String message) {
        super(message);
    }
}
