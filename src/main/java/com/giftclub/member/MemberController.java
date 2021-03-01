package com.giftclub.member;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/members")
public class MemberController {

    private SignupService signupService;


    @PostMapping("/signup")
    public Member signup(@RequestBody Member member) throws Exception {
        this.signupService.validateSignUp(member);
        return this.signupService.signup(member);

    }

    @PostMapping("/login")
    public Member login(@RequestBody Map<String, String> loginParams, HttpSession session) throws NoSuchAlgorithmException {
        Member member = this.signupService.login(loginParams.get("memberEmail"), loginParams.get("memberPassword"));
        session.setAttribute("member", member);
        return member;
    }

}
