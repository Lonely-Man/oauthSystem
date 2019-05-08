package com.oauthsystem.server.entity;

import lombok.Data;

@Data
public class ApiResult<T> {
    private boolean success;
    private String code;
    private String message;
    private  T data;
    private long total;
    public static<T> ApiResult<T> buildSuccessApiResult(String code,String message,T data,long total){
        ApiResult<T> apiResult=new ApiResult<>();
        apiResult.setSuccess(true);
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setTotal(total);
        return apiResult;
    }
}
