package com.giftclub.mapper;

import com.giftclub.store.Store;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreMapper {

    public void insertStore(Store store);

    public boolean isStoreExists(String storeName);
}
