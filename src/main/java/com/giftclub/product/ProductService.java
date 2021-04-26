package com.giftclub.product;

import com.giftclub.common.SessionUtils;
import com.giftclub.common.exception.UserNotFoundException;
import com.giftclub.common.exception.ValidationException;
import com.giftclub.mapper.ProductMapper;
import com.giftclub.mapper.StoreMapper;
import com.giftclub.store.Store;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductMapper productMapper;
    private final StoreMapper storeMapper;
    private final SessionUtils sessionUtils;

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

    @Transactional
    public void updateProduct(Product product) {

        Store store = storeMapper.selectStoreById(product.getStoreId());

        if (store.getMemberId().equals(sessionUtils.getLoginMember().getMemberId())) {
            productMapper.updateProduct(product);
        } else {
            throw new UserNotFoundException("상점 주인의 권한이 없습니다.");
        }
    }
}
