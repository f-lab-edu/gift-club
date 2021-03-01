package com.giftclub.member;

import com.giftclub.common.exception.ValidationException;
import com.giftclub.common.security.PasswordEncoder;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.security.NoSuchAlgorithmException;

@Service
@AllArgsConstructor
public class MemberService {

    private MemberMapper memberMapper;
    private PasswordEncoder passwordEncoder;


    public Member signup(Member member) throws NoSuchAlgorithmException {
        member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
        this.memberMapper.insertMember(member);
        return member;
    }

    public void validateSignUp(final Member member) {
        if (memberMapper.checkEmailExists(member.getMemberEmail()) == 1) {
            throw new ValidationException("이미 존재하는 이메일입니다.");
        }
    }


}
