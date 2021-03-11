package com.giftclub.common;

import com.giftclub.member.Member;

public interface MemberAuthentication {

    public Member loginSession(String memberEmail, String memberPassword);
}
