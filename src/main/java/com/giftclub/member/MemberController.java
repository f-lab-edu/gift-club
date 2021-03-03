package com.giftclub.member;

import com.giftclub.common.ResponseService;
import com.giftclub.common.model.CommonResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/members")
public class MemberController {
  private final ResponseService responseService;
  private final MemberService memberService;
  private final SessionLoginService sessionLoginService;

  @PostMapping("/signup")
  public Member signup(@RequestBody Member member) throws Exception {
    memberService.validateSignUp(member);
    return memberService.signup(member);
  }

  @PostMapping("/login")
  public CommonResult login(@RequestBody Map<String, String> loginParams, HttpSession session) {

    sessionLoginService.login(
        loginParams.get("memberEmail"), loginParams.get("memberPassword"), session);
    return responseService.getSuccessResult();
  }
}
