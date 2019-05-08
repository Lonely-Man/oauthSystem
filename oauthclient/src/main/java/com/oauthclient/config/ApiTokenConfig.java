package com.oauthclient.config;

import com.oauthclient.annotation.ApiToken;
import com.oauthclient.entity.ApiResult;
import lombok.Getter;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

@Component
@Aspect
public class ApiTokenConfig {
    private static final String type="token";
    @Autowired
    private HttpServletRequest request;
    @Around("@annotation(com.oauthclient.annotation.ApiToken)")
    public ApiResult dd(ProceedingJoinPoint joinPoint ) throws Throwable{
        String token=request.getHeader(type);
        if(token==null){
            return ApiResult.buildFailApiResult("-1","无令牌",null,0);
        }
        Signature signature=joinPoint.getSignature();
        MethodSignature methodSignature=(MethodSignature)signature;
        ApiToken apiToken=methodSignature.getMethod().getAnnotation(ApiToken.class);
        String value=apiToken.value();
        //todo 业务判断

        joinPoint.proceed();
        return ApiResult.buildSuccessApiResult(null,null,null,0);
    }
}
