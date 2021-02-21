package com.giftclub.shop;

import com.giftclub.shop.domain.Shop;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ShopService {
    @Autowired
    private ShopMapper shopMapper;


    @Transactional(rollbackFor = Exception.class)
    public Shop add(final Shop shop) {
        shopMapper.insert(shop);
        return shop;

    }
}
