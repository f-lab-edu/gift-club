package com.giftclub.member;

import com.giftclub.common.SessionUtils;
import com.giftclub.common.exception.MemberRoleException;
import com.giftclub.common.exception.ValidationException;
import com.giftclub.common.security.Encoder;
import com.giftclub.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberMapper memberMapper;
    private final SessionUtils sessionUtils;
    private final Encoder encoder;

    @Transactional
    public Member signUp(Member member) {

        validateSignUp(member);
        member.setMemberPassword(encoder.encode(member.getMemberPassword()));
        this.memberMapper.insertMember(member);
        return member;
    }

    public void validateSignUp(final Member member) {

        if (memberMapper.checkEmailExists(member.getMemberEmail())) {
            throw new ValidationException("이미 존재하는 이메일입니다.");
        }
    }

    @Transactional
    public Member update(final Member member) {

        member.setMemberPassword(encoder.encode(member.getMemberPassword()));
        memberMapper.updateMemberByMemberId(member);
        return member;

    }

    @Transactional
    public void delete() {

        memberMapper.deleteMemberByMemberId(sessionUtils.getLoginMember().getMemberId());

    }
}
