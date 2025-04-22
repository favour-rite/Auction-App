package org.example.exception;

public class IncorrectEmailException extends RuntimeException {
    public IncorrectEmailException(String message){
        super(message);
    }
}
