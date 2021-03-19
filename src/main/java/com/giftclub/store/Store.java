package com.giftclub.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Builder
public class Store {

    private Long storeId;

    @NonNull
    private Long storeCategoryId;

    @NonNull
    private String memberId;

    @NonNull
    private String storeName;

    @NonNull
    private int storePhone;

    @NonNull
    private String storeIntroduce;

}
