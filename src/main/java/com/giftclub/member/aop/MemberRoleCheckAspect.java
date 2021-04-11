package com.giftclub.member.aop;

import com.giftclub.common.SessionUtils;
import com.giftclub.common.exception.MemberRoleException;
import com.giftclub.mapper.MemberMapper;
import com.giftclub.member.LoginService;
import com.giftclub.member.Member;
import com.giftclub.member.MemberRole;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberRoleCheckAspect {

    private final LoginService loginService;

    @Before("@annotation(com.giftclub.member.aop.MemberRoleCheck) && @annotation(target)")
    public void memberRoleCheck(MemberRoleCheck target) {

        switch (target.memberRole()) {
            case ADMIN:
                adminLoginCheck();
                break;
            case USER:
                memberLoginCheck();
                break;
            case SELLER:
                sellerLoginCheck();
                break;
            default:
                throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED);
        }
    }

    public Member getCurrentMember() {

        Member member = loginService.getCurrentMember();
        return member;
    }

    public void adminLoginCheck() {

        Member member = getCurrentMember();
        if (member.getMemberTypeId() != MemberRole.ADMIN.getTypeId())
            throw new MemberRoleException("관리자만 가능합니다.");
    }

    public void memberLoginCheck() {

        Member member = getCurrentMember();
        if (member.getMemberTypeId() != MemberRole.USER.getTypeId())
            throw new MemberRoleException("일반회원만 가능합니다");
    }

    public void sellerLoginCheck() {

        Member member = getCurrentMember();
        if (member.getMemberTypeId() != MemberRole.SELLER.getTypeId())
            throw new MemberRoleException("판매자만 가능합니다.");
    }
}
