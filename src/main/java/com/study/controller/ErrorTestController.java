package com.study.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * test error handler
 *
 * @author ByrsH
 * @create 2017-10-15 17:53
 **/
@Controller
@RequestMapping(value = "/test")
public class ErrorTestController {
    @RequestMapping(value = "/error/404")
    public String error404(HttpServletRequest request){
        return "test/error404";
    }
}
