package com.giftclub.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
@AllArgsConstructor
public class MemberType {

    private Long memberTypeId;

    @NonNull
    private String memberTypeName;

}
