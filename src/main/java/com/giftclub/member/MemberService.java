package com.giftclub.member;

import com.giftclub.common.exception.LoginFailedException;
import com.giftclub.common.exception.ValidationException;
import com.giftclub.common.security.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    public Member signup(Member member) {
        member.setMemberPassword(PasswordEncoder.encode(member.getMemberPassword()));
        memberMapper.insertMember(member);
        return member;
    }

    public void validateSignUp(final Member member) {
        if (Member.checkNullRequiredField(member)) {
            throw new ValidationException("필수인자 누락입니다.");
        } else if (memberMapper.checkEmailExists(member.getMemberEmail()) == null) {
            throw new ValidationException("이미 존재하는 이메일입니다.");
        }
    }

    public Member login(final String memberEmail, final String memberPassword) {
        final Member matchMember = memberMapper.checkEmailExists(memberEmail);
        if (matchMember == null) {
            throw new LoginFailedException("사용자가 존재하지 않습니다.");
        } else if (!PasswordEncoder.matches(memberPassword, matchMember.getMemberPassword())) {
            throw new LoginFailedException("비밀번호가 일치하지 않습니다.");
        }
        return matchMember;
    }
}
