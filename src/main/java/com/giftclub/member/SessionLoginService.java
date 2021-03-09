package com.giftclub.member;

import com.giftclub.common.exception.LoginFailedException;
import com.giftclub.common.security.Encoder;
import com.giftclub.common.utils.SessionUtils;
import com.giftclub.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;


/**
 * 세션을 이용하는 콘트롤러. 세션을 이용할 예정인 메소드들만 모아놓음.
 */
@Service
@RequiredArgsConstructor
public class SessionLoginService {

    private final HttpSession httpSession;
    private final MemberMapper memberMapper;
    private final Encoder encoder;

    public void login(String memberEmail, String memberPassword) {
        Member matchMember = memberMapper.getMemberByMemberEmail(memberEmail);
        if (matchMember == null | !encoder.matches(memberPassword, matchMember.getMemberPassword())) {
            throw new LoginFailedException("사용자가 존재하지 않거나 비밀번호가 틀렸습니다.");
        }
        SessionUtils.setLoginMemberId(httpSession, matchMember.getMemberId());
        return;
    }
}
