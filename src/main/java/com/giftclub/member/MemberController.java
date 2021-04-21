package com.giftclub.member;

import com.giftclub.member.aop.LoginRequired;
import com.giftclub.member.request.MemberLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

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

    @PostMapping("/logout")
    @LoginRequired
    public void logout() {

        loginService.logout();
    }

    @PostMapping("/signUp")
    public Member signup(@RequestBody Member member) {

        return memberService.signUp(member);
    }

    @LoginRequired
    @PutMapping
    public Member update(@RequestBody Member memberUpdateRequest) {

        return memberService.update(memberUpdateRequest);
    }

    @LoginRequired
    @DeleteMapping
    public void delete() {

        memberService.delete();
    }
}
