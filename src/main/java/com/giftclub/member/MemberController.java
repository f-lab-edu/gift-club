package com.giftclub.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@RequestMapping(value = "/members")
public class MemberController {

    private MemberService memberService;
    private SessionLoginService sessionLoginService;

    @Autowired
    public MemberController(MemberService memberService, SessionLoginService sessionLoginService) {
        this.memberService = memberService;
        this.sessionLoginService = sessionLoginService;
    }

    @PostMapping("/signup")
    public Member signup(@RequestBody Member member) throws Exception {
        memberService.validateSignUp(member);
        return memberService.signup(member);

    }

    @PostMapping("/login")
    public Member login(@RequestBody Map<String, String> loginParams, HttpSession session) throws NoSuchAlgorithmException {
        Member member = sessionLoginService.login(loginParams.get("memberEmail"), loginParams.get("memberPassword"), session);
        return member;
    }

}
