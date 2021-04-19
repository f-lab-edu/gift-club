package com.giftclub.store;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Store {

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
