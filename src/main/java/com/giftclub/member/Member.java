package com.giftclub.member;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Member {

    private Long memberId;

    @NonNull
    private String memberEmail;

    @NonNull
    private String memberName;

    @NonNull
    private String memberPassword;

    @NonNull
    private String memberNumber;

    private LocalDate memberBirth;
}


