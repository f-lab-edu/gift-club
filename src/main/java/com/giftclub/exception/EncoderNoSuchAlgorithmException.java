package com.giftclub.exception;

public class EncoderNoSuchAlgorithmException extends RuntimeException{

    public EncoderNoSuchAlgorithmException() {
    }

    public EncoderNoSuchAlgorithmException(String message) {
        super(message);
    }

    public EncoderNoSuchAlgorithmException(String message, Throwable cause) {
        super(message, cause);
    }
}
