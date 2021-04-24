package com.giftclub.product;

import lombok.*;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int price;

    @NonNull
    private Long stock;

    @NonNull
    private String information;

    @NonNull
    private Long storeId;

    public Product(Long stock) {
        this.stock = stock;
    }
}
