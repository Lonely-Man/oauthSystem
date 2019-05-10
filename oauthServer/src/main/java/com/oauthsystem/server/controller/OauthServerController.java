package com.oauthsystem.server.controller;

import com.oauthsystem.server.entity.ApiResult;
import com.oauthsystem.server.entity.User;
import com.oauthsystem.server.service.OauthClientService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
public class OauthServerController {
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private OauthClientService oauthClientService;
    @PostMapping("/getCode")
    public ApiResult va(@Param("clientId") String clientId, @RequestBody User user){
        //todo 验证 clientId  用户信息
        oauthClientService.findByClientId(clientId);
        String code="";
        String message="";
        long total=0;
        String data="code";
        String codeToken="123456";

        return  ApiResult.buildSuccessApiResult(codeToken,message,data,total);
    }
    @PostMapping("/getToken")
    public ApiResult getToken(String codeToken){
        String code="";
        String message="";
        long total=0;
        String data="code";
        if(!redisTemplate.hasKey(codeToken)){
            return  ApiResult.buildFailApiResult(code,message);
        }

        return  ApiResult.buildSuccessApiResult(code,message,data,total);
    }
}
