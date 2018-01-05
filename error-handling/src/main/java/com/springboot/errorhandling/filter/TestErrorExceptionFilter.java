package com.springboot.errorhandling.filter;

import com.springboot.errorhandling.web.ErrorCode;
import com.springboot.errorhandling.web.GlobalErrorException;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 19:57 2018/1/4
 * @Modified By:
 */

public class TestErrorExceptionFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        try {
            judge(servletRequest, servletResponse);
        } catch (GlobalErrorException e) {
            e.printStackTrace();
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }

    private void judge(ServletRequest servletRequest, ServletResponse servletResponse) throws GlobalErrorException{
        throw new GlobalErrorException(ErrorCode.ERROR_PARAMETER);
    }
}
