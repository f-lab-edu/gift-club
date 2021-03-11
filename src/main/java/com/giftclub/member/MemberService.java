package com.giftclub.member;

import com.giftclub.common.Sha256;
import com.giftclub.exception.ValidationException;
import com.giftclub.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final Sha256 sha256;

    public Member regist(Member member) throws SQLException {
        member.setMemberPassword(sha256.encryption(member.getMemberPassword()));
        memberMapper.insertMember(member);
        return member;
    }

    public void checkEmail(String email) {
       if(memberMapper.findByEmail(email)){
           throw new ValidationException("이미 존재하는 이메일입니다.");
       }
    }
}
