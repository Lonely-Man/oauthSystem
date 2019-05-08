package com.oauthclient.controller;

import com.oauthclient.annotation.ApiToken;
import com.oauthclient.entity.ApiResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthServerController {
    @ApiToken(value = "user-list")
    @GetMapping("/userList")
    public ApiResult getUserList(){
        String code="";
        String message="";
        long total=0;
        String data="code";
        return  ApiResult.buildSuccessApiResult(code,message,data,total);
    }
}
