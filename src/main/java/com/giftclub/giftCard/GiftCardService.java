package com.giftclub.giftCard;

import com.giftclub.common.SessionUtils;
import com.giftclub.mapper.GiftCardMapper;
import com.giftclub.mapper.ProductMapper;
import com.giftclub.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class GiftCardService {

    private final GiftCardMapper giftCardMapper;
    private final SessionUtils sessionUtils;
    private final ProductService productService;

    @Transactional
    public void gift(GiftCard giftCard) {

        giftCard.setToMemberId(sessionUtils.getLoginMember().getMemberId());
        productService.decreaseProduct(giftCard.getProductId());
        giftCardMapper.insertGift(giftCard);
    }
}
