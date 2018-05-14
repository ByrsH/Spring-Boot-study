package com.byrsh.login.controller;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 10:50 2018/5/14
 * @Modified By:
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @RequestMapping(value = "/hello",method = RequestMethod.GET)
    public String sayHello(HttpServletRequest request){
        return "hello!";
    }

}
