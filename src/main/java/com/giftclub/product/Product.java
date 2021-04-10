package com.giftclub.product;

import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Product {

    private Long id;

    @NonNull
    private String name;

    @NonNull
    private int price;

    @Setter
    @NonNull
    private int stock;

    @NonNull
    private String information;

    @NonNull
    private Long storeId;
}
