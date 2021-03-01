package com.giftclub.common.security;

import java.security.NoSuchAlgorithmException;

public abstract class PasswordEncoder {
    public boolean matches(String password, String originalPassword) throws NoSuchAlgorithmException {
        return this.encode(password).equals(originalPassword);
    }

    public abstract String encode(String memberPassword) throws NoSuchAlgorithmException;
}
