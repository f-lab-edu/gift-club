package com.giftclub.store;

import lombok.*;

@Getter
@Builder
public class StoreCategory {

    private Long storeCategoryId;

    @NonNull
    private String storeCategoryName;
}
