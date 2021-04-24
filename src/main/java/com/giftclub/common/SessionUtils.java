package com.giftclub.common;

import com.giftclub.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;

@Slf4j
@Component
@RequiredArgsConstructor
public class SessionUtils {

    private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    private static final String LOGIN_MEMBER = "LOGIN_MEMBER";
    private final HttpSession httpSession;

    public Long getLoginMemberId() {
        return (Long) httpSession.getAttribute(LOGIN_MEMBER_ID);
    }

    public Member getLoginMember() {
        return (Member) httpSession.getAttribute(LOGIN_MEMBER);
    }

    public void setLoginMember(Member member) {
        httpSession.setAttribute(LOGIN_MEMBER, member);
    }

    public void deleteLoginMemberId() {
        httpSession.removeAttribute(LOGIN_MEMBER_ID);
        log.info("세션 LOGIN_MEMBER_ID 삭제 후 세션아이디 null 정상반영 여부:{}", (getLoginMemberId() == null));
    }
}