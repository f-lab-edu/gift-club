package com.giftclub.common.exception;

public class EncoderNoSuchAlgorithmException extends RuntimeException {

    private static final long serialVersionUID = 5881505127689355910L;

    public EncoderNoSuchAlgorithmException() {
    }

    public EncoderNoSuchAlgorithmException(final String message) {
        super(message);
    }

    public EncoderNoSuchAlgorithmException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
