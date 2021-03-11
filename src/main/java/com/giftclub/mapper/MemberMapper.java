package com.giftclub.mapper;

import com.giftclub.member.Member;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;

@Mapper
public interface MemberMapper {
    public void insertMember(Member member) throws SQLException;

    public Member findByEmailAndPassword(String memberEmail, String memberPassword);

    public boolean findByEmail(String email);
}
