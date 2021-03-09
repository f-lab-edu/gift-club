package com.giftclub.member;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/members")
public class MemberController {

    private final MemberService memberService;

    @PostMapping("/signup")
    public Member signup(@RequestBody Member member) throws Exception {
        memberService.validateSignUp(member);
        return memberService.signup(member);
    }


}
