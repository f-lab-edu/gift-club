package com.giftclub.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping(value = "/member")
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(final MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public Member signup(@RequestBody final Member member) throws Exception {
        memberService.validateSignUp(member);
        return memberService.signup(member);

    }

    @PostMapping("/login")
    public Member login(@RequestBody Map<String, String> loginParams, HttpSession session) {
        Member member = memberService.login(loginParams.get("memberEmail"), loginParams.get("memberPassword"));
        session.setAttribute("member", member);
        return member;
    }

}
