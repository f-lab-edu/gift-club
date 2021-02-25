package com.giftclub.member;

import com.giftclub.common.exception.LoginFailedException;
import com.giftclub.common.exception.ValidationException;
import com.giftclub.common.security.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private final MemberMapper memberMapper;

    public MemberService(final MemberMapper memberMapper) {
        this.memberMapper = memberMapper;
    }

    /**
     * 회원가입(고객)
     * * 비밀번호를 암호화한다.
     *
     * @param member 저장할 회원의 정보
     * @return member 저장된 회원의 정보
     */
    public Member SignUp(Member member) {
        member.setMemberPassword(PasswordEncoder.encode(member.getMemberPassword()));
        this.memberMapper.insertMember(member);
        return member;
    }

    /**
     * 회원가입(고객)의 유효성 검사이다.
     * 필수 인자 null check 와  중복 이메일 아이디를 검사한다.
     * 에러시, 에러를 일으키고, 성공적으로 유효할 시, 다음 코드로 넘어간다.
     *
     * @param member
     */
    public void validateSignUp(final Member member) {
        if (Member.checkNullRequiredField(member)) {
            throw new ValidationException("필수인자 누락입니다.");
        } else if (this.memberMapper.checkEmailExists(member.getMemberEmail()) == null) {
            throw new ValidationException("이미 존재하는 이메일입니다.");
        }
    }

    /**
     * 로그인(회원)
     *
     * @param memberEmail    고객 이메일 아이디
     * @param memberPassword 고객 비밀번호
     * @return member  해당하는 고객 정보를 반환한다.
     */
    public Member login(final String memberEmail, final String memberPassword) {
        final Member matchMember = this.memberMapper.checkEmailExists(memberEmail);
        if (matchMember == null) {
            throw new LoginFailedException("사용자가 존재하지 않습니다.");
        } else if (!PasswordEncoder.matches(memberPassword, matchMember.getMemberPassword())) {
            throw new LoginFailedException("비밀번호가 일치하지 않습니다.");
        }
        return matchMember;
    }
}
