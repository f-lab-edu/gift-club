package com.giftclub.member;

/**
 * 개방 폐쇄 원칙을 지키기 위한
 * <세션 기반, 토큰 기반> 로그인 기능을 고려한 로그인 인터페이스입니다.
 */
public interface LoginService {

    public String login(String memberEmail, String memberPassword);
}
