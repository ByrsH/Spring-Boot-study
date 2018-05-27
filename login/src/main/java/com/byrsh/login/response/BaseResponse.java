package com.byrsh.login.response;

import com.byrsh.login.util.ErrorInfo;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 9:26 2018/5/3
 * @Modified By:
 */
public class BaseResponse implements Serializable {

    private String msg;

    private Integer code;

    public BaseResponse() {}

    public BaseResponse(String msg, Integer code) {
        this.msg = msg;
        this.code = code;
    }

    public BaseResponse(ErrorInfo errorInfo) {
        this.msg = errorInfo.getErrorMsg();
        this.code = errorInfo.getErrorCode();
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
