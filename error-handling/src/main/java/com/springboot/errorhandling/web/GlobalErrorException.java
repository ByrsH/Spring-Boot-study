package com.springboot.errorhandling.web;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 11:15 2018/1/4
 * @Modified By:
 */
public class GlobalErrorException extends Exception{

    private ErrorCodeInterface errorCode;

    public GlobalErrorException(){}

    public GlobalErrorException(ErrorCodeInterface errorCode) {
        this.errorCode = errorCode;
    }

    public ErrorCodeInterface getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeInterface errorCode) {
        this.errorCode = errorCode;
    }
}
