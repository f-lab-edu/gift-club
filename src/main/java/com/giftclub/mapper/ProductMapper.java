package com.giftclub.mapper;

import com.giftclub.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {

    public void insertProduct(Product product);
}
