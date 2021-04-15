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

    public Product selectProductById(Long id) {

        return productMapper.selectProductById(id);
    }

    public void decreaseProduct(Long id) {

        Product productStock = selectProductById(id);
        productStock.setStock(productStock.getStock() - 1);
        productMapper.decreaseProduct(id, productStock.getStock());
    }
}
