package com.giftclub.common.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.FORBIDDEN)
public class MemberRoleException extends RuntimeException {

    public MemberRoleException(String message) {
        super(message);
    }
}

