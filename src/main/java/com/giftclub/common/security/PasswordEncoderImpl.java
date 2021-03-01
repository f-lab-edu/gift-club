package com.giftclub.common.security;

import java.security.MessageDigest;

public class PasswordEncoder {
    public static String bytesToHex(byte[] bytes) {
        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    public static String encode(String memberPassword) {

        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(memberPassword.getBytes());`
        return bytesToHex(md.digest());

    }

    public static boolean matches(String memberPassword, String realUserPassword) {
        return encode(memberPassword).equals(encode(realUserPassword));
    }
}
