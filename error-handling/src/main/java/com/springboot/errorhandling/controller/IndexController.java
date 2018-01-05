package com.springboot.errorhandling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 21:17 2017/12/13
 * @Modified By:
 */

@Controller
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String hello(HttpServletRequest request){
        return "hello";
    }
}
