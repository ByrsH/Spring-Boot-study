package com.study.controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServlet;

/**
 * @author ByrsH
 * @create 2017-07-03 22:19
 **/


@Controller
public class IndexController {
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {
        return "hello";
    }
}
