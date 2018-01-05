package com.springboot.errorhandling.web;

import java.io.Serializable;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 11:21 2018/1/4
 * @Modified By:
 */
public class ApiResponseBody<T> implements Serializable {
    private int error;
    private String message;
    private T result;

    public ApiResponseBody(ErrorCodeInterface errorCodeInterface){
        this.error = errorCodeInterface.getErrorCode();
        this.message = errorCodeInterface.getErrorMessage();
    }

    public ApiResponseBody(ErrorCodeInterface errorCodeInterface, T result){
        this.error = errorCodeInterface.getErrorCode();
        this.message = errorCodeInterface.getErrorMessage();
        this.result = result;
    }

    public int getError() {
        return error;
    }

    public void setError(int error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }
}
