package com.giftclub.member;

import com.giftclub.common.Sha256;
import com.giftclub.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final Sha256 sha256;

    public Member regist(Member member) throws SQLException {
        sha256.encryption(member.getMemberPassword());
        memberMapper.insertMember(member);
        return member;
    }
    public Member login(String memberEmail, String memberPassword) throws SQLException {
       sha256.encryption(memberPassword);
       return memberMapper.findByEmailAndPassword(memberEmail, memberPassword);
    }

    public void checkEmail(String email) {
       if(memberMapper.findByEmail(email)){
           throw new ValidationException("이미 존재하는 이메일입니다.");
       }
    }
}
