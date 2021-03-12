package com.giftclub.common.security;

public interface Encoder {

    public boolean matches(String rawPassword, String encodedPassword);

    public String encode(String memberPassword);
}
