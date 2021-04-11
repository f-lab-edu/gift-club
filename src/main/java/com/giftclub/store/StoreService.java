package com.giftclub.store;

import com.giftclub.common.exception.ValidationException;
import com.giftclub.mapper.StoreMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StoreService {

    private final StoreMapper storeMapper;

    @CacheEvict(value = "selectStoreById")
    public void registStore(Store store) {
        storeMapper.insertStore(store);
    }

    public void validateStore(String storeName) {
        if (storeMapper.isStoreExists(storeName)) {
            throw new ValidationException("이미 존재하는 상호명입니다.");
        }
    }
    @Cacheable(value = "selectStoreById")
    public Store selectStoreById(Long storeId) {
       return storeMapper.selectStoreById(storeId);
    }
}
