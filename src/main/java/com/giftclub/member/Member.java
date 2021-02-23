package com.giftclub.member;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@Builder
public class Member {
    private Long memberId;
    private String memberEmail;
    private String memberName;
    private String memberPassword;
    private Date memberBirth;
}


