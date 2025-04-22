package org.example.exception;

public class PaymentAlreadyConfirmedException extends RuntimeException{
    public PaymentAlreadyConfirmedException(String message) {
        super(message);
    }
}
