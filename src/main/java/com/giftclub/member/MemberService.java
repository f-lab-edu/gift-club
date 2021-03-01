package com.giftclub.member;

import com.giftclub.common.exception.LoginFailedException;
import com.giftclub.common.exception.ValidationException;
import com.giftclub.common.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class SignupService {

    private MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder;


    public Member signup(Member member) throws NoSuchAlgorithmException {
        member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
        this.memberMapper.insertMember(member);
        return member;
    }

    public void validateSignUp(final Member member) {
        if (memberMapper.checkEmailExists(member.getMemberEmail()) == null) {
            throw new ValidationException("이미 존재하는 이메일입니다.");
        }
    }

    public Member login(String memberEmail, String memberPassword) throws NoSuchAlgorithmException {
        Member matchMember = memberMapper.checkEmailExists(memberEmail);
        if (matchMember == null) {
            throw new LoginFailedException("사용자가 존재하지 않습니다.");
        } else if (!passwordEncoder.matches(memberPassword, matchMember.getMemberPassword())) {
            throw new LoginFailedException("비밀번호가 일치하지 않습니다.");
        }
        return matchMember;
    }
}
