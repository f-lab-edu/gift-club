package com.giftclub.common;

import com.giftclub.exception.LoginFailedException;
import com.giftclub.member.Member;
import com.giftclub.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
@RequiredArgsConstructor
public class LoginSession implements MemberAuthentication {

    private final HttpSession session;
    private final MemberMapper memberMapper;
    private final Sha256 sha256;

    @Override
    public Member loginSession(String memberEmail, String memberPassword) {
        String sha256Password = sha256.encryption(memberPassword);
        Member memberInfo = memberMapper.findByEmailAndPassword(memberEmail, sha256Password);

        if(memberInfo == null){
            throw new LoginFailedException("회원정보가 틀렸습니다.");
        }else {
            session.setAttribute("member", memberInfo);
        }
        return memberInfo;
    }
}
