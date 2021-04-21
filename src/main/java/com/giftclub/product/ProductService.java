package com.giftclub.product;

import com.giftclub.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }
}
