package com.giftclub.store;

import com.giftclub.member.MemberService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/stores")
public class StoreController {

    private final StoreService storeService;
    private final MemberService memberService;

    @PostMapping("/register")
    public void insertStore(@RequestBody Store store){
        memberService.getMemberByMemberId(store.getMemberId());
        storeService.validateStore(store.getStoreName());
        storeService.insertStore(store);
    }

}
