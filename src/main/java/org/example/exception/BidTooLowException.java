package org.example.exception;

public class BidTooLowException extends RuntimeException {
    public BidTooLowException(String message) {
        super(message);
    }
}
