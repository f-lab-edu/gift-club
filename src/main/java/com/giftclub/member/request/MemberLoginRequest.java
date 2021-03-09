package com.giftclub.member.request;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class MemberLoginRequest {

    @NonNull
    String memberEmail;

    @NonNull
    String memberPassword;

}