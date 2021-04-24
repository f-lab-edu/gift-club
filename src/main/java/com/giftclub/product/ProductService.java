package com.giftclub.product;

import com.giftclub.mapper.ProductMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;

    public void insertProduct(Product product) {
        productMapper.insertProduct(product);
    }

    public Product selectProductById(Long id) {

        return productMapper.selectProductById(id);
    }

    @Transactional
    public void decreaseProduct(Long id) {

        Product productStock = selectProductById(id);

        productMapper.decreaseProduct(id, productStock.getStock() - 1);
    }
}
