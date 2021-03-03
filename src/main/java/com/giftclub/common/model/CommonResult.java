package com.giftclub.common.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonResult {
  /** 응답 성공여부 응답 메시지 */
  private boolean success;

  private String msg;
}
