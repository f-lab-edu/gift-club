package com.giftclub.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Builder
public class StoreCategory {

    private Long storeCategoryId;

    @NonNull
    private String storeCategoryName;
}
