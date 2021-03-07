package com.giftclub.common.response;

import com.giftclub.common.model.CommonResult;
import lombok.Getter;

public class ResponseService {

    // 실패 결과만 처리하는 메소드
    public static CommonResult getFailResult() {
        return new CommonResult(CommonResponse.FAIL.getSuccess(), CommonResponse.FAIL.getMsg());
    }

    // 성공 결과만 처리하는 메소드
    public static CommonResult getSuccessResult() {
        return new CommonResult(CommonResponse.SUCCESS.getSuccess(), CommonResponse.SUCCESS.getMsg());
    }


    // enum으로 api 요청 결과에 대한 code, message를 정의합니다.
    @Getter
    public enum CommonResponse {

        SUCCESS(true, "success"),
        FAIL(false, "failure");

        String msg;
        Boolean success;

        CommonResponse(Boolean success, String msg) {
            this.msg = msg;
            this.success = success;
        }
    }
}
