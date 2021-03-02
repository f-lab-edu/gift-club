package com.giftclub.member;

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

@RestController("/member")
@RequiredArgsConstructor
public class MemberController {

   private final MemberService memberService;


   @PostMapping("/regist")
   public ResponseEntity register(@RequestBody Member member) throws SQLException {
      if(memberService.checkEmail(member.getMemberEmail()) != null){
         return new ResponseEntity<>(member, HttpStatus.NOT_FOUND);
      }
      return new ResponseEntity<>(memberService.regist(member), HttpStatus.OK);

   }

   @PostMapping("/login")
   public Object login(String memberEmail, String memberPassword, HttpSession session) throws SQLException {

      try {
         Member memberInfo = memberService.login(memberEmail, memberPassword);
         if (memberInfo != null) {
            session.setAttribute("memberInfo", memberInfo);
            return new ResponseEntity<>(memberService.login(memberEmail, memberPassword), HttpStatus.OK);
         }
      } catch (Exception e) {
         e.printStackTrace();
         return new ResponseEntity<>(memberService.login(memberEmail, memberPassword), HttpStatus.NOT_FOUND);
      }
      return memberService.login(memberEmail, memberPassword);
   }
}
