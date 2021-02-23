package com.giftclub.member;

import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {

   private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
