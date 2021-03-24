package com.giftclub.common;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Slf4j
@Component
public class SessionUtils {
    private final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    @Autowired
    private HttpSession httpSession;


    public Long getLoginMemberId() {

        return (Long) httpSession.getAttribute(LOGIN_MEMBER_ID);
    }

    public void setLoginMemberId(Long memberId) {
        log.info("setLoginMemberId" + memberId);
        httpSession.setAttribute("LOGIN_MEMBER_ID", memberId);
    }

    public void deleteLoginMemberId() {

        httpSession.removeAttribute(LOGIN_MEMBER_ID);
    }
}