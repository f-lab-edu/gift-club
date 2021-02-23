package com.giftclub.member;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

import java.util.Date;

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
    private Date memberBirth;

    public static boolean checkNullRequiredField(Member member) {
        return member.getMemberPassword() == null || member.getMemberName() == null || member.getMemberEmail() == null;
    }
}


