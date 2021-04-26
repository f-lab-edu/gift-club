package com.giftclub.giftCard;

import com.giftclub.member.aop.LoginRequired;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "giftCards")
public class GiftCardController {

    private final GiftCardService giftCardService;

    @PostMapping
    @LoginRequired
    public void gift(@RequestBody GiftCard giftCard) {
        giftCardService.gift(giftCard);
    }
}
