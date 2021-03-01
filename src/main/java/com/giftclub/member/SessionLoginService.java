package com.giftclub.member;

import com.giftclub.common.exception.LoginFailedException;
import com.giftclub.common.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class SessionLoginService {
    private MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder;

    public Member login(String memberEmail, String memberPassword, HttpSession session) throws NoSuchAlgorithmException {
        Member matchMember = memberMapper.getMemberByMemberEmail(memberEmail);
        if (matchMember == null) {
            throw new LoginFailedException("사용자가 존재하지 않습니다.");
        } else if (!passwordEncoder.matches(memberPassword, matchMember.getMemberPassword())) {
            throw new LoginFailedException("비밀번호가 일치하지 않습니다.");
        }
        session.setAttribute("member", matchMember);
        return matchMember;
    }
}
