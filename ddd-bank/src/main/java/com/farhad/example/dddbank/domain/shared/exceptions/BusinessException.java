package com.farhad.example.dddbank.domain.shared.exceptions;

public abstract class BusinessException extends RuntimeException{

    protected BusinessException() {
        super();
    }

    protected BusinessException(String message) {
        super(message);
    }

    protected BusinessException(Throwable cause) {
        super(cause);
    }

    protected BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
