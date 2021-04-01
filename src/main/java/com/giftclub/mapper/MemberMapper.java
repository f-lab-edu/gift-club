package com.giftclub.mapper;

import com.giftclub.member.Member;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberMapper {

    public void insertMember(Member member);

    public boolean checkEmailExists(String memberEmail);

    public Member getMemberByMemberEmail(String memberEmail);

    public void updateMemberByMemberId(Member member);

    public void deleteMemberByMemberId(Long memberId);

    public Member getMemberByMemberId(Long memberId);
}
