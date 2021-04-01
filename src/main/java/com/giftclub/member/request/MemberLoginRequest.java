package com.giftclub.member.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.ToString;

@Getter
@Builder
@ToString
public class MemberLoginRequest {

    @NonNull
    String memberEmail;

    @NonNull
    String memberPassword;

}