package com.byrsh.login.interceptor;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 10:48 2018/5/14
 * @Modified By:
 */
public class AccessRequestInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        System.out.println("sdfdf");
        return true;
    }

}
