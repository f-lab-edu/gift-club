package com.giftclub.member;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class Member {

    private Long memberId;

    private Long memberTypeId;

    @NonNull
    private String memberEmail;

    @NonNull
    private String memberName;

    @NonNull
    private String memberPassword;

    private LocalDate memberBirth;

}
