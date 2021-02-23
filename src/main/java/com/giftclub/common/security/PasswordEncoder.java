package com.giftclub.common.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordEncoder {
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public static String encode(String memberPassword) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(memberPassword.getBytes());
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            throw new RuntimeException("PasswordEncoder Error : SHA-256", e);
        }
    }

    public static boolean matches(String memberPassword, String memberPassword1) {
        return encode(memberPassword).equals(encode(memberPassword1));
    }
}
