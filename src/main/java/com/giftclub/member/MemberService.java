package com.giftclub.member;

import com.giftclub.common.exception.ValidationException;
import com.giftclub.common.security.PasswordEncoder;
import com.giftclub.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {

  private final MemberMapper memberMapper;
  private final PasswordEncoder passwordEncoder;

  public Member signup(Member member) {
    member.setMemberPassword(passwordEncoder.encode(member.getMemberPassword()));
    this.memberMapper.insertMember(member);
    return member;
  }

  public void validateSignUp(final Member member) {
    if (memberMapper.checkEmailExists(member.getMemberEmail())) {
      throw new ValidationException("이미 존재하는 이메일입니다.");
    }
  }
}
