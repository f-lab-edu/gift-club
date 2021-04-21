package com.giftclub.store;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreCategory {

    private Long storeCategoryId;

    @NonNull
    private String storeCategoryName;
}
