package com.giftclub.order.domain;

import com.giftclub.product.domain.Product;
import lombok.Data;

@Data
public class OrderItem {
    private Product product;
    private int price;
    private int quantity;
}
