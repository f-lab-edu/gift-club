package com.giftclub.member;

import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {
    int insertMember(Member member);

    Member checkEmailExists(String memberEmail);
}
