package com.giftclub.member;

import com.giftclub.common.SessionUtils;
import com.giftclub.common.exception.LoginFailedException;
import com.giftclub.common.security.Encoder;
import com.giftclub.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;


/**
 * 세션을 이용하는 콘트롤러. 세션을 이용할 예정인 메소드들만 모아놓음.
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class SessionLoginService implements LoginService {

    final String LOGIN_MEMBER_ID = "LOGIN_MEMBER_ID";
    private final SessionUtils sessionUtils;
    private final MemberMapper memberMapper;
    private final Encoder encoder;

    @Override
    public String login(String memberEmail, String memberPassword) {

        Member matchMember = memberMapper.getMemberByMemberEmail(memberEmail);
        if (matchMember == null | !encoder.matches(memberPassword, matchMember.getMemberPassword())) {
            throw new LoginFailedException("사용자가 존재하지 않거나 비밀번호가 틀렸습니다.");
        }

        log.info(matchMember.getMemberId() + "member" + matchMember.getMemberId());
        sessionUtils.setLoginMemberId((Long) matchMember.getMemberId());
        log.info("login after: 기존세션아이디" + sessionUtils.getLoginMemberId());

        return null;
    }

    @Override
    public void logout() {

        log.info("기존세션아이디" + sessionUtils.getLoginMemberId());
        sessionUtils.deleteLoginMemberId();
        log.info("로그아웃후세션아이디: null=" + (sessionUtils.getLoginMemberId() == null));

    }

}
