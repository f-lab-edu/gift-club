package com.giftclub.store;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreCategory {

    private Long storeCategoryId;

    @NonNull
    private String storeCategoryName;
}
