package com.giftclub.store;

import com.giftclub.member.Member;
import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store implements Serializable {

    private Long storeId;

    @NonNull
    private Long storeCategoryId;

    @NonNull
    private Long memberId;

    @NonNull
    private String storeName;

    @NonNull
    private String storePhone;

    private String storeIntroduce;
    private StoreCategory storeCategory;
    private String memberName;
}
