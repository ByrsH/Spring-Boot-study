package com.springboot.errorhandling.controller;

import com.springboot.errorhandling.util.ApiUtils;
import com.springboot.errorhandling.web.ErrorCode;
import com.springboot.errorhandling.web.GlobalErrorException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 16:19 2018/1/2
 * @Modified By:
 */
@RestController
@RequestMapping("/api")
public class IndexServiceController {

    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public ResponseEntity index(HttpServletRequest request) throws Exception {
        int a = 1/0;
        return new ResponseEntity(a, HttpStatus.OK);
    }

    @RequestMapping(value = "/test/jsonError")
    public ResponseEntity jsonError(HttpServletRequest request) throws Exception{
        try {
            int a = 1/0;
        }catch (Exception e){
            throw new GlobalErrorException(ErrorCode.ERROR_PARAMETER);
        }
        return ApiUtils.getResponseBody(ErrorCode.OK);
    }

    @RequestMapping(value = "/test/interceptorException")
    public ResponseEntity intptExp(HttpServletRequest request) throws Exception{
        return ApiUtils.getResponseBody(ErrorCode.OK);
    }

    @RequestMapping(value = "/test/filterException")
    public ResponseEntity filterExp(HttpServletRequest request) throws Exception{
        return ApiUtils.getResponseBody(ErrorCode.OK);
    }

}
