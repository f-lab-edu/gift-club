package com.giftclub.store;

import com.giftclub.member.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;
    private final MemberService memberService;

    @PostMapping
    public void insertStore(@RequestBody Store store) {
        memberService.getMemberByMemberId(store.getMemberId());
        storeService.validateStore(store.getStoreName());
        storeService.insertStore(store);
    }

    @GetMapping("/{storeId}")
    public void selectStoreById(@PathVariable Long storeId) {
        storeService.selectStoreById(storeId);
    }

    @PutMapping
    public void modifyStoreById(@RequestBody Store store) {
        storeService.validateStore(store.getStoreName());
        storeService.modifyStoreById(store);
    }

}
