package com.giftclub.common;

import com.giftclub.member.Member;

public interface LoginService {

    public Member loginSession(String memberEmail, String memberPassword);
}
