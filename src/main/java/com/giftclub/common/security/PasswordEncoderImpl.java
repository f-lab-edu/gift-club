package com.giftclub.common.security;

import com.giftclub.common.exception.PasswordNoSuchAlgorithmException;
import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class PasswordEncoderImpl implements PasswordEncoder {

  public static String bytesToHex(byte[] bytes) {
    StringBuilder builder = new StringBuilder();
    for (byte b : bytes) {
      builder.append(String.format("%02x", b));
    }
    return builder.toString();
  }

  @Override
  public String encode(String memberPassword) {
    try {
      MessageDigest md = MessageDigest.getInstance("SHA-256");
      md.update(memberPassword.getBytes());
      return bytesToHex(md.digest());
    } catch (NoSuchAlgorithmException e) {
      throw new PasswordNoSuchAlgorithmException(e.toString());
    }
  }

  @Override
  public boolean matches(String rawPassword, String encodedPassword) {
    return this.encode(rawPassword).equals(encodedPassword);
  }
}
