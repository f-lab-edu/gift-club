package com.giftclub.exception;

public class EncoderNoSuchAlgorithmException extends RuntimeException{

    public EncoderNoSuchAlgorithmException() {
    }

    public EncoderNoSuchAlgorithmException(final String message) {
        super(message);
    }

    public EncoderNoSuchAlgorithmException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
