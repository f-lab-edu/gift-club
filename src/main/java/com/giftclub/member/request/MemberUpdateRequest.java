package com.giftclub.member.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

import java.time.LocalDate;

@Getter
@Builder
@ToString //Transfer Object 패턴은 ToString 을 붙여주는 것이 좋다
public class MemberUpdateRequest {

    @NonNull
    private String memberName;

    @NonNull
    private String memberPassword;

    private LocalDate memberBirth;
}
