package com.giftclub.common;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Component
public class SessionUtils {
    final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    private final HttpSession httpSession;

    public void logout() {
        httpSession.removeAttribute(LOGIN_MEMBER_ID);
    }

    public Long getLoginMemberId() {

        return (Long) httpSession.getAttribute(LOGIN_MEMBER_ID);
    }

    public void setLoginMemberId(Long memberId) {

        httpSession.setAttribute(LOGIN_MEMBER_ID, memberId);
    }

    public void deleteLoginMemberId() {

        httpSession.setAttribute(LOGIN_MEMBER_ID, getLoginMemberId());
    }
}