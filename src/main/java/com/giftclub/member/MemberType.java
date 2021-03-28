package com.giftclub.member;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class MemberType {

    private Long memberTypeId;

    @NonNull
    private String memberTypeName;

}
