package org.example.exception;

public class CannotCancelSomeoneElseBid extends  RuntimeException {
    public CannotCancelSomeoneElseBid(String message) {
        super (message);
    }
}
