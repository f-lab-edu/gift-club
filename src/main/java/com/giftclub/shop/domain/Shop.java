package com.giftclub.shop.domain;

import com.giftclub.product.domain.Product;
import lombok.Data;

import java.util.List;

@Data
public class Shop {
    private int id;
    private String name;
    private String description;
    private List<Product> productList;
}
