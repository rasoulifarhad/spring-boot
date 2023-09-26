package com.farhad.example.gamefification.academic.domain.exception;

public class InvalidCpfException extends RuntimeException {
    
    private static final long serialVersionUID = 4272952226134501263L;
    
    public InvalidCpfException(String message) {
        super(message);
    }
}
