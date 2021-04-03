package com.giftclub.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Product {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int price;

    @NonNull
    private String information;

    @NonNull
    private Long storeId;
}
