package com.springboot.errorhandling.controller.error;

import com.springboot.errorhandling.web.ApiResponseBody;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.beans.Customizer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/**
 * @Author: yrs
 * @Description: 该类会覆盖 BasicErrorController类，错误处理会在这里处理。
 *              注意： 测试时请去掉@Controller注解
 * @Date: Greated in 16:31 2018/1/3
 * @Modified By:
 */
//@Controller
public class CustomizeErrorController extends BasicErrorController{

    public CustomizeErrorController(){
        super(new DefaultErrorAttributes(), new ErrorProperties());
    }

    @RequestMapping(
            produces = {"text/html"}
    )
    public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
        HttpStatus status = this.getStatus(request);
        Map<String, Object> model = Collections.unmodifiableMap(this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.TEXT_HTML)));
        response.setStatus(status.value());
        ModelAndView modelAndView = this.resolveErrorView(request, response, status, model);
        return modelAndView == null ? new ModelAndView("error/"+status.value(), model) : modelAndView;
    }

    @RequestMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        Map<String, Object> body = this.getErrorAttributes(request, this.isIncludeStackTrace(request, MediaType.ALL));
        HttpStatus status = this.getStatus(request);
        ApiResponseBody responseBody = new ApiResponseBody((int)body.get("status"), (String) body.get("error"));
        return new ResponseEntity(responseBody, status);
    }


}
