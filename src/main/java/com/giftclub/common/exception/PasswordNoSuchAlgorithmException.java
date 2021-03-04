package com.giftclub.common.exception;

public class PasswordNoSuchAlgorithmException extends RuntimeException {

  private static final long serialVersionUID = 5881505127689355910L;

  public PasswordNoSuchAlgorithmException() {}

  public PasswordNoSuchAlgorithmException(final String message) {
    super(message);
  }

  public PasswordNoSuchAlgorithmException(final String message, final Throwable cause) {
    super(message, cause);
  }
}
