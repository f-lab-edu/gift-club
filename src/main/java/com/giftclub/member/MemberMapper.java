package com.giftclub.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    public int insertMember(Member member);

    public Member checkEmailExists(String memberEmail);
}
