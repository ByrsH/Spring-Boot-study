package com.springboot.errorhandling.web;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 11:35 2018/1/6
 * @Modified By:
 */
public class CustomRuntimeException  extends RuntimeException{
    private ErrorCodeInterface errorCode;

    public CustomRuntimeException() {}

    public CustomRuntimeException(ErrorCodeInterface errorCode){
        this.errorCode = errorCode;
    }

    public ErrorCodeInterface getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCodeInterface errorCode) {
        this.errorCode = errorCode;
    }
}
