package com.giftclub.common.exception;

public class LoginFailedException extends RuntimeException {

    private static final long serialVersionUID = -7648433239804956791L;

    public LoginFailedException() {
    }

    public LoginFailedException(final String message) {
        super(message);
    }

    public LoginFailedException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
