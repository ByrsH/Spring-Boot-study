package com.springboot.errorhandling.web;

import org.springframework.boot.autoconfigure.web.ErrorController;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 20:38 2018/1/3
 * @Modified By:
 */
public enum  ErrorCode implements ErrorCodeInterface {
    /** 0表示成功 **/
    OK(0,"成功"),

    /** 500开头的是系统异常错误 **/
    ERROR_SYSTEM(50000, "系统内部错误"),
    ERROR_SMS_CODE_SEND(500001, "短信验证码发送异常"),

    /** 400开头的是请求参数不对 **/
    ERROR_PARAMETER(40000, "参数错误"),
    ;

    private String errorMessage;
    private int errorCode;


    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public ErrorCode errorMessage(String errorMessage){
        this.errorMessage = errorMessage;
        return this;
    }

    @Override
    public String getErrorMessage() {
        return this.errorMessage;
    }

    @Override
    public int getErrorCode() {
        return this.errorCode;
    }
}
