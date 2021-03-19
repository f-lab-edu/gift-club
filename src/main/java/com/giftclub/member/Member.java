package com.giftclub.member;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
public class Member {

    private Long memberId;

    @NonNull
    private String memberEmail;

    @NonNull
    private String memberName;

    @NonNull
    private String memberPassword;

    private LocalDate memberBirth;
}


