package com.giftclub.store;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StoreCategory {

    private Long categoryId;

    @NonNull
    private String category_type;
}
