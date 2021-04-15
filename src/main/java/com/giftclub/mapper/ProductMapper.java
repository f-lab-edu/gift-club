package com.giftclub.mapper;

import com.giftclub.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductMapper {

    public void insertProduct(Product product);

    public Product selectProductById(Long id);

    public void decreaseProduct(Long id, int stock);
}
