package com.giftclub.common.exception;

public class UserNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 110914010930753363L;

    public UserNotFoundException() {
    }

    public UserNotFoundException(final String message) {
        super(message);
    }

    public UserNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
