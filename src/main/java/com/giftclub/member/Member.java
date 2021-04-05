package com.giftclub.member;

import com.giftclub.store.Store;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class Member implements Serializable {

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
