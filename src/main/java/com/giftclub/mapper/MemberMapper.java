package com.giftclub.mapper;

import com.giftclub.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    public void insertMember(Member member);

    public Member findByEmailAndPassword(String memberEmail);

    public boolean findByEmail(String email);
}
