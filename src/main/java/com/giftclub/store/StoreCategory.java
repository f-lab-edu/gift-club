package com.giftclub.store;

import lombok.*;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StoreCategory implements Serializable {

    private Long storeCategoryId;

    @NonNull
    private String storeCategoryName;
}
