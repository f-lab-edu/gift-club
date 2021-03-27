package com.giftclub.store;

import lombok.*;
import org.springframework.stereotype.Service;

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

}
