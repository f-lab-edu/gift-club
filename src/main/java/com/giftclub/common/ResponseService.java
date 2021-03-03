package com.giftclub.common;

import com.giftclub.common.model.CommonResult;
import org.springframework.stereotype.Service;

@Service // 해당 Class가 Service임을 명시합니다.
public class ResponseService {

  // 실패 결과만 처리하는 메소드
  public static CommonResult getFailResult(int code, String msg) {
    CommonResult result = new CommonResult();
    result.setSuccess(false);
    result.setMsg(msg);
    return result;
  }

  // 성공 결과만 처리하는 메소드
  public CommonResult getSuccessResult() {
    CommonResult result = new CommonResult();
    setSuccessResult(result);
    return result;
  }

  // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
  private void setSuccessResult(CommonResult result) {
    result.setSuccess(true);
    result.setMsg(CommonResponse.SUCCESS.getMsg());
  }
  // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
  public enum CommonResponse {
    SUCCESS("success"),
    FAIL("failure");

    String msg;

    CommonResponse(String msg) {
      this.msg = msg;
    }

    public String getMsg() {
      return msg;
    }
  }
}
