package com.giftclub.member;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Api(tags = "User", description = "사용자  API")
@RestController("/members")
@RequiredArgsConstructor
public class MemberController {

   private final MemberService memberService;

   @ApiOperation(value = "가입하기", notes = "중복 이메일, 이름을 검사합니다.")
   @PostMapping("/regist")
   public Member register(@RequestBody Member member) throws SQLException {

      memberService.checkEmail(member.getMemberEmail());
      return memberService.regist(member);
   }

   @ApiOperation(value = "로그인", notes = "성공시 session을 생성합니다.")
   @PostMapping("/login")
   public Member login(String memberEmail, String memberPassword, HttpSession session) throws SQLException {

      try {
         Member memberInfo = memberService.login(memberEmail, memberPassword);
         if (memberInfo != null) {
            session.setAttribute("memberInfo", memberInfo);
            return memberService.login(memberEmail, memberPassword);
         }
      } catch (Exception e) {
         e.printStackTrace();
         return memberService.login(memberEmail, memberPassword);
      }
      return memberService.login(memberEmail, memberPassword);
   }
}
