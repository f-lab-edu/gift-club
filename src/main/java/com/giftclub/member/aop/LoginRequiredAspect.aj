package com.giftclub.member.aop;

import com.giftclub.common.SessionUtils;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpSession;

@Slf4j
@Aspect
@SuppressWarnings("unchecked")
@Component
public class LoginRequiredAspect {

    @Autowired
    private SessionUtils sessionUtils;


    @Around("@annotation(LoginRequired)")
    public Object loginRequired(ProceedingJoinPoint joinPoint) throws Throwable {

        log.debug("loginRequired 진입");
        HttpSession session = ((ServletRequestAttributes) (RequestContextHolder.currentRequestAttributes())).getRequest().getSession();
        if (sessionUtils.getLoginMemberId() == null) {
            log.info("loginRequired null");
            throw new HttpClientErrorException(HttpStatus.UNAUTHORIZED); //unchecked exception extends RuntimeException
        }
        return joinPoint.proceed();//execution target method

    }

}
