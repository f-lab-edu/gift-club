package com.giftclub.store;

import com.giftclub.member.MemberRole;
import com.giftclub.member.MemberService;
import com.giftclub.member.aop.MemberRoleCheck;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/stores")
public class StoreController {

    private final StoreService storeService;

    @PostMapping
    @MemberRoleCheck(memberRole = MemberRole.SELLER)
    public void insertStore(@RequestBody Store store) {

        storeService.validateStore(store.getStoreName());
        storeService.registStore(store);
    }

    @GetMapping("/{storeId}")
    public Store selectStoreById(@PathVariable Long storeId) {
        return storeService.selectStoreById(storeId);
    }

}
