package com.giftclub.common;

import com.giftclub.exception.LoginFailedException;
import com.giftclub.mapper.MemberMapper;
import com.giftclub.member.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginSession implements MemberAuthentication {

    private final HttpSession session;
    private final MemberMapper memberMapper;
    private final Sha256 sha256;

    @Override
    public Member loginSession(String memberEmail, String memberPassword) {
        log.info("진입");
        String sha256Password = sha256.encryption(memberPassword);
        log.info("진입2");
        Member memberInfo = memberMapper.findByEmailAndPassword(memberEmail);
        if (memberInfo == null) {
            throw new LoginFailedException("회원정보가 틀렸습니다.");
        } else {
            session.setAttribute("member", memberInfo);
        }
        return memberInfo;
    }
}
