package com.byrsh.login.util;

import javax.validation.constraints.NotNull;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 16:11 2018/4/28
 * @Modified By:
 */

public enum ErrorInfo {
    /** 2000表示成功 **/
    OK(2000,"OK"),

    /**3001 无效的app_key或app_secret**/
    ERROR_INVALID_KEY_SECRET(3000, "invalid app_key or app_secret"),
    /**3002 无效的访问令牌**/
    ERROR_ACCESS_TOKER(3002, "invalid access_token"),
    /**3003 用户在其他设备登录**/
    ERROR_LOGIN_OTHER_DEVICE(3003, "user login other device"),
    /**3004 请求超时**/
    ERROR_REQUEST_TIMEOUT(3004, "request timeout"),
    /**3005 重复请求**/
    ERROR_REQUEST_REPEAT(3005, "request repeat"),
    /**3006 参数签名错误**/
    ERROR_SIGN(3006, "sign error"),


    /**4000 参数不全或格式不对**/
    ERROR_PARAMETER(4000, "parameter error"),
    /**4001 参数不能为null**/
    ERROR_PARAMETER_IS_NULL(4001, "parameter is null"),

    /**5000 用户名或密码错误**/
    ERROR_USERNAME_OR_PASSWORD(5000, "username or password error"),
    /**5001 用户名或密码为空**/
    ERROR_USERNAME_OR_PASSWORD_EMPTY(5001, "username or password is empty"),
    /**5002 email已被使用**/
    ERROR_EMAIL_EXIST(5002, "email exist"),
    /**5003 手机号已被使用**/
    ERROR_PHONE_EXIST(5003, "phone number exist"),
    /**5004 手机号还没注册**/
    ERROR_PHONE_UNREGISTER(5004, "unregister phone"),
    /**5005 密码重置失败**/
    ERROR_RESET_PASSWORD(5004, "reset password error"),
    /**5006 验证码错误**/
    ERROR_AUTH_CODE(5006, "auth_code error"),
    /**5007 密码太短**/
    ERROR_PASSWORD_TOO_SHORT(5007, "password too short"),
    /**5008 密码太长**/
    ERROR_PASSWORD_TOO_LONG(5008, "password too long"),
    /**5009 原始密码错误**/
    ERROR_OLD_PASSWORD(5009, "old password error"),
    /**5010 手机号为空**/
    ERROR_PHONE_EMPTY(5010, "phone is empty"),
    /**5011 密码为null**/
    ERROR_PASSWORD_NULL(5011, "password is null"),
    /**5012 登出失败**/
    ERROR_LOGOUT_FAILURE(5012, "logout failure"),
    /**5014 两次密码输入不同**/
    ERROR_TWO_PASSWORD_NOT_SAME(5014, "two password is not same"),


    /**6001 短信发送失败**/
    ERROR_SMS_FAILURE(6001, "sms failure"),
    /**6002 邮件发送失败**/
    ERROR_EMAIL_FAILURE(6002, "sms failure"),


    ;

    /////////////////////////////////////////////////////////////////
    private String errorMsg;
    private final int errorCode;

    ErrorInfo(@NotNull String errorMsg) {
        this.errorCode = 0;
        this.errorMsg = errorMsg;
    }

    ErrorInfo(@NotNull int error) {
        this.errorCode = error;
        this.errorMsg = "";
    }

    ErrorInfo(@NotNull int errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }


    public ErrorInfo errorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
        return this;
    }

    @NotNull
    public String getErrorMsg() {
        return this.errorMsg;
    }


    public int getErrorCode() {
        return errorCode;
    }

}