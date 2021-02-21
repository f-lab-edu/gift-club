package com.giftclub.product.domain;

import lombok.Data;

@Data
public class Product {
    private int id;
    private int shopId;
    private String name;
    private String description;
    private int price;
    private int discount;
}
