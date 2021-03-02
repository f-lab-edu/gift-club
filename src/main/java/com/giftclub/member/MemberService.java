package com.giftclub.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MemberService {


    private final MemberMapper memberMapper;

    public int regist(Member member) throws SQLException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(member.getMemberPassword().getBytes());
            member.setMemberPassword(String.format("%040x", new BigInteger(1, md.digest())));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
     return memberMapper.insertMember(member);
    }
    public Member login(String memberEmail, String memberPassword) throws SQLException {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(memberPassword.getBytes());
            memberPassword.format("%040x", new BigInteger(1, md.digest()));
        }
        catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return memberMapper.findByEmailAndPassword(memberEmail, memberPassword);
    }

    public Member checkEmail(String email) throws SQLException {
       return  memberMapper.checkEmail(email);
    }
}
