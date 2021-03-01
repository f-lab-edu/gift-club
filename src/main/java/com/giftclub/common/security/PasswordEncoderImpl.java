package com.giftclub.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoderImpl extends PasswordEncoder {
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    @Override
    public String encode(String memberPassword) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(memberPassword.getBytes());
        return PasswordEncoderImpl.bytesToHex(md.digest());

    }

}
