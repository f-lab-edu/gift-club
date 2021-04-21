package com.giftclub.member.request;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MemberLoginRequest {

    @NonNull
    String memberEmail;

    @NonNull
    String memberPassword;

}