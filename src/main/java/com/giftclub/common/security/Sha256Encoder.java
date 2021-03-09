package com.giftclub.common.security;

import com.giftclub.common.exception.EncoderNoSuchAlgorithmException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class Sha256Encoder implements Encoder {

    public static final String ENCRYPTION_TYPE = "SHA-256";

    public static String bytesToHex(byte[] bytes) {

        StringBuilder builder = new StringBuilder();
        for (byte b : bytes) {
            builder.append(String.format("%02x", b));
        }
        return builder.toString();
    }

    @Override
    public String encode(String st) {

        try {
            MessageDigest md = MessageDigest.getInstance(ENCRYPTION_TYPE);
            md.update(st.getBytes());
            return bytesToHex(md.digest());
        } catch (NoSuchAlgorithmException e) {
            throw new EncoderNoSuchAlgorithmException("SHA256EncoderNoSuchAlgorithmException", e);
        }
    }

    @Override
    public boolean matches(String rawSt, String encodedSt) {
        return this.encode(rawSt).equals(encodedSt);
    }
}
