package com.giftclub.member;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.Map;

@Api(tags = "Member", description = "사용자 API")
@RestController("/member")
@RequiredArgsConstructor
public class MemberController {

   private final MemberService memberService;

   @ApiOperation(value = "가입하기", notes = "중복 이메일, 이름을 검사합니다.")
   @PostMapping("/regist")
   public ResponseEntity register(@RequestBody Member member) throws SQLException {
      if(memberService.checkEmail(member.getMemberEmail()) != null){
         return new ResponseEntity<>(member, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(memberService.regist(member), HttpStatus.OK);

   }
   @ApiOperation(value = "로그인", notes = "중복 이메일, 이름을 검사합니다.")
   @PostMapping("/login")
   public ResponseEntity<Member> login(Map<String, String> map) throws SQLException {

      return new ResponseEntity<>(memberService.login(map),HttpStatus.OK);
   }
}
