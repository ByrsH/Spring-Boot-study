package com.byrsh.login.controller;

import org.springframework.beans.factory.annotation.Autowired;
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
public class LoginController {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(HttpServletRequest request){
        stringRedisTemplate.opsForValue().set("yrs", "aa");
        return "ok";
    }

}
