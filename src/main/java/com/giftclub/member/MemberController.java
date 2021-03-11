package com.giftclub.member;

import com.giftclub.member.request.MemberLoginRequest;
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
    private final LoginService loginService;


    @PostMapping("/login")
    public String login(@RequestBody MemberLoginRequest memberLoginRequest) {

        return loginService.login(
                memberLoginRequest.getMemberEmail(), memberLoginRequest.getMemberPassword());
    }

    @PostMapping("/signup")
    public Member signup(@RequestBody Member member) throws Exception {

        memberService.validateSignUp(member);
        return memberService.signup(member);
    }


}
