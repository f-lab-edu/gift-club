package com.giftclub.store;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
public class StoreCategory {

    private Long storeCategoryId;

    @NonNull
    private String storeCategoryName;
}
