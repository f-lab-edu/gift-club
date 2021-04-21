package com.giftclub.member.aop;

import com.giftclub.common.SessionUtils;
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
public class LoginRequiredAspect {

    private final SessionUtils sessionUtils;

    @Around("@annotation(com.giftclub.member.aop.LoginRequired)")
    public Object loginRequired(ProceedingJoinPoint joinPoint) throws Throwable {

        if (sessionUtils.getLoginMember() == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED); // 인증(로그아웃됨) 401 에러 , unchecked exception extends RuntimeException
        }

        return joinPoint.proceed(); //execution target method
    }

}
