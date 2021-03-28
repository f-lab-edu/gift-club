package com.giftclub.product;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

@Getter
@Builder
public class Product {

    private Long productId;

    @NonNull
    private String productName;

    @NonNull
    private int productPrice;

    @NonNull
    private String productInformation;

    @NonNull
    private Long storeId;
}
