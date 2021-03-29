package com.giftclub.common;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionUtils {

    private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    private final HttpSession httpSession;


    public Long getLoginMemberId() {

        return (Long) httpSession.getAttribute(LOGIN_MEMBER_ID);
    }

    public void setLoginMemberId(Long memberId) {


        httpSession.setAttribute(LOGIN_MEMBER_ID, memberId);
        log.debug("세션 LOGIN_MEMBER_ID 적용: {}", memberId);
    }

    public void deleteLoginMemberId() {

        httpSession.removeAttribute(LOGIN_MEMBER_ID);
        log.debug("세션 LOGIN_MEMBER_ID 삭제 후 세션아이디 null 정상반영 여부:{}", (getLoginMemberId() == null));
    }
}