package com.giftclub.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
  /** 응답 여부 success: 성공여부 반환 code: 응답 코드 ( ) msg: 응답 메시지 상세 */
  private boolean success;

  private int code;
  private String msg;
}
