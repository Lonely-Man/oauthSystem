package com.oauthsystem.server.controller;

import com.oauthsystem.server.entity.ApiResult;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OauthServerController {
    public ApiResult va(String clientId){
        String code="";
        String message="";
        long total=0;
        String data="code";
        return  ApiResult.buildSuccessApiResult(code,message,data,total);
    }
}
