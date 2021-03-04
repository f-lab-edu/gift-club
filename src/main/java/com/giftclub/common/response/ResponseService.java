package com.giftclub.common.response;

import com.giftclub.common.model.CommonResult;
import lombok.Getter;
import org.springframework.stereotype.Service;

@Service // 해당 Class가 Service임을 명시합니다.
public class ResponseService {

  // 실패 결과만 처리하는 메소드
  public static CommonResult getFailResult(int code, String msg) {
    CommonResult result = new CommonResult();
    result.setSuccess(false);
    result.setCode(-9999);
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
    result.setCode(CommonResponse.SUCCESS.getCode());
    result.setMsg(CommonResponse.SUCCESS.getMsg());
  }

  // 실패 결과만 처리하는 메소드
  public CommonResult getFailureResult() {
    CommonResult result = new CommonResult();
    setFailureResult(result);
    return result;
  }

  // 결과 모델에 api 요청 성공 데이터를 세팅해주는 메소드
  private void setFailureResult(CommonResult result) {
    result.setSuccess(true);
    result.setCode(CommonResponse.FAIL.getCode());
    result.setMsg(CommonResponse.FAIL.getMsg());
  }
  // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
  @Getter
  public enum CommonResponse {
    SUCCESS("success", 200),
    FAIL("failure", -9999);

    String msg;
    int code;

    CommonResponse(String msg, int code) {
      this.msg = msg;
      this.code = code;
    }
  }
}
