package com.springboot.errorhandling.filter;

import com.springboot.errorhandling.web.ErrorCode;
import com.springboot.errorhandling.web.GlobalErrorException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 14:25 2018/1/5
 * @Modified By:
 */
@Component
public class TestExceptionInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        if (request.getRequestURI().contains("/api/test/interceptorException")){
            throw new GlobalErrorException(ErrorCode.ERROR_PARAMETER);
        }
        return true;
    }
}
