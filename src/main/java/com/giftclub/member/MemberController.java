package com.giftclub.member;

import com.giftclub.common.MemberAuthentication;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;

@Api(tags = "User", description = "사용자  API")
@RestController
@RequestMapping(value = "/members")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;
    private final MemberAuthentication loginSession;

    @ApiOperation(value = "가입하기", notes = "중복 이메일, 이름을 검사합니다.")
    @PostMapping("/regist")
    public void register(@RequestBody Member member) throws SQLException {

        memberService.checkEmail(member.getMemberEmail());
        memberService.regist(member);
    }

    @ApiOperation(value = "로그인", notes = "성공시 session을 생성합니다.")
    @PostMapping("/login")
    public void login(@RequestParam String memberEmail, @RequestParam String memberPassword) {
        loginSession.loginSession(memberEmail, memberPassword);
    }
}
