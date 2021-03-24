package com.giftclub.member.aop;

import com.giftclub.common.SessionUtils;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

@Aspect
@Component
@RequiredArgsConstructor
public aspect LoginRequiredAspect {

    private final SessionUtils sessionUtils;

    @Before("@annotation(LoginRequired)")
    public void loginRequired(ProceedingJoinPoint method) throws Throwable {
        if (sessionUtils.getLoginMemberId() == null) {
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED); //unchecked exception  extends RuntimeException
        }
        method.proceed();
    }

}
