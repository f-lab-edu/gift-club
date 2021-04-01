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
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Aspect
@Slf4j
@Component
@RequiredArgsConstructor
public class MemberRoleCheckAspect {

    private final MemberMapper memberMapper;
    private final LoginService loginService;

    @Around("@annotation(com.giftclub.member.aop.MemberRoleCheck)")
    public Object memberRoleCheck(ProceedingJoinPoint joinPoint) throws Throwable {
        Long memberId = loginService.getCurrentMember();
        Member member = memberMapper.getMemberByMemberId(memberId);
        if (member.getMemberTypeId() != MemberRole.SELLER.getTypeId()) {
            throw new MemberRoleException("판매자만 등록할 수 있습니다.");
        }
        return joinPoint.proceed();
    }

}
