package com.giftclub.member;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Repository;

import java.sql.SQLException;
import java.util.Map;

@Mapper
public interface MemberMapper {
    public void insertMember(Member member) throws SQLException;

    public Member findByEmailAndPassword(String memberEmail, String memberPassword) throws SQLException;

    public boolean findByEmail(String email);
}
