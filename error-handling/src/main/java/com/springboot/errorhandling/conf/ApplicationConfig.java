package com.springboot.errorhandling.conf;

import com.springboot.errorhandling.filter.TestExceptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 14:33 2018/1/5
 * @Modified By:
 */
@Configuration
public class ApplicationConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TestExceptionInterceptor testExceptionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(testExceptionInterceptor);
    }
}
