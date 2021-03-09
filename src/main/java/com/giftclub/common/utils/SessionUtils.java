package com.giftclub.common.utils;

import lombok.NonNull;

import javax.servlet.http.HttpSession;

public class SessionUtils {

    private static final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";

    private SessionUtils() {
    }

    public static void setLoginMemberId(HttpSession session, @NonNull Long memberId) {
        session.setAttribute(LOGIN_MEMBER_ID, memberId);
    }

    public static void logoutMember(HttpSession session) {
        session.removeAttribute(LOGIN_MEMBER_ID);
    }

    public static Long getLoginMemberId(HttpSession session) {
        return (Long) session.getAttribute(LOGIN_MEMBER_ID);
    }
}
