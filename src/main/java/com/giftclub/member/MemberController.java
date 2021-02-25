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
    public Member signup(@RequestBody Member member) throws Exception {
        this.memberService.validateSignUp(member);
        return this.memberService.SignUp(member);
    }

    @PostMapping("/login")
    public Member login(@RequestBody final Map<String, String> loginParams, final HttpSession session) {
        final Member member =
                this.memberService.login(loginParams.get("memberEmail"), loginParams.get("memberPassword"));
        session.setAttribute("member", member);
        return member;
    }
}
