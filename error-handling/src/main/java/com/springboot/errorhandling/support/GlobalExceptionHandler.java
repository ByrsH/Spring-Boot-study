package com.springboot.errorhandling.support;

import com.springboot.errorhandling.util.ApiUtils;
import com.springboot.errorhandling.web.CustomRuntimeException;
import com.springboot.errorhandling.web.ErrorCode;
import com.springboot.errorhandling.web.ErrorCodeInterface;
import com.springboot.errorhandling.web.GlobalErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 11:38 2018/1/4
 * @Modified By:
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";

    @ExceptionHandler(value = GlobalErrorException.class)
    @ResponseBody
    public ResponseEntity jsonErrorHandle(HttpServletRequest request, GlobalErrorException exception){
        ErrorCodeInterface errorCodeInterface = exception.getErrorCode();
        return ApiUtils.getResponseBody(errorCodeInterface);
    }

    /*
    @ExceptionHandler(value = GlobalErrorException.class)
    public ModelAndView ErrorHandle(HttpServletRequest request, GlobalErrorException exception){
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception", exception.toString());
        mav.addObject("url", request.getRequestURL());
        mav.setViewName(DEFAULT_ERROR_VIEW + "/custom");
        return mav;
    }
    */

    @ExceptionHandler(value = CustomRuntimeException.class)
    @ResponseBody
    public ResponseEntity customRuntimeExt(HttpServletRequest request, CustomRuntimeException exception){
        ErrorCodeInterface errorCodeInterface = exception.getErrorCode();
        return ApiUtils.getResponseBody(errorCodeInterface);
    }

    /*
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseEntity jsonErrorHandle(HttpServletRequest request, Exception exception){
        ErrorCode errorCode = ErrorCode.ERROR_SYSTEM.errorMessage(exception.getMessage());

        ErrorCodeInterface errorCodeInterface = errorCode;
        return ApiUtils.getResponseBody(errorCode);
    }
    */
}
