package com.giftclub.mapper;

import com.giftclub.giftCard.GiftCard;
import com.giftclub.product.Product;
import org.springframework.stereotype.Repository;

@Repository
public interface GiftCardMapper {

    public void insertGift(GiftCard giftCard);
}
