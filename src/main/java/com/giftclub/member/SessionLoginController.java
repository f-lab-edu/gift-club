package com.giftclub.member;

import com.giftclub.common.model.CommonResult;
import com.giftclub.common.response.ResponseService;
import com.giftclub.member.request.MemberLoginRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/")
public class SessionLoginController {

    private final SessionLoginService sessionLoginService;


    @PostMapping("/login")
    public CommonResult login(@RequestBody MemberLoginRequest memberLoginRequest) {

        sessionLoginService.login(
                memberLoginRequest.getMemberEmail(), memberLoginRequest.getMemberPassword());
        return ResponseService.getSuccessResult();
    }
}
