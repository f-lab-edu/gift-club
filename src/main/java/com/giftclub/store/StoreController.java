package com.giftclub.store;

import com.giftclub.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stores/{storeId}")
public class StoreController {

    private final StoreService storeService;
    private final MemberService memberService;

    @PostMapping
    public void insertStore(@RequestBody Store store) {
        memberService.getMemberByMemberId(store.getMemberId());
        storeService.validateStore(store.getStoreName());
        storeService.insertStore(store);
    }

    @GetMapping
    public void selectStoreById(@PathVariable Long storeId) {
        storeService.selectStoreById(storeId);
    }

}
