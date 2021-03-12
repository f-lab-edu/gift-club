package com.giftclub.common.exception;

public class ValidationException extends RuntimeException {

    private static final long serialVersionUID = 6924654334035724606L;

    public ValidationException() {
    }

    public ValidationException(String message) {
        super(message);
    }

    public ValidationException(String message, Throwable cause) {
        super(message, cause);
    }
}
