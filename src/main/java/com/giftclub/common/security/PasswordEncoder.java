package com.giftclub.common.security;

public interface PasswordEncoder {

  public boolean matches(String rawPassword, String encodedPassword);

  public abstract String encode(String memberPassword);
}
