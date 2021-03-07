package com.giftclub.common.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;

@Getter
@AllArgsConstructor
public class CommonResult {

    /**
     * 응답 여부 success: 성공여부 반환 msg: 응답 메시지 상세
     */
    @NonNull
    private boolean success;
    @NonNull
    private String msg;
}
