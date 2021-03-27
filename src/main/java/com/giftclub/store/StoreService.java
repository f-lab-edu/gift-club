package com.giftclub.store;

import com.giftclub.common.exception.ValidationException;
import com.giftclub.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper storeMapper;

    public void insertStore(Store store) {
        storeMapper.insertStore(store);
    }

    public void validateStore(String storeName) {
        if (storeMapper.isStoreExists(storeName)) {
            throw new ValidationException("이미 존재하는 상호명입니다.");
        }
    }

    public void selectStoreById(Long storeId) {
        storeMapper.selectStoreById(storeId);
    }

    public void modifyStoreById(Store store) {
        storeMapper.modifyStoreById(store);
    }
}
