package com.byrsh.login.conf;

import com.byrsh.login.interceptor.AccessRequestInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: yangrusheng
 * @Description:
 * @Date: Created in 11:35 2018/5/14
 * @Modified By:
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(accessRequestInterceptor()).addPathPatterns("/user/**");
    }

    @Bean
    public AccessRequestInterceptor accessRequestInterceptor(){
        return new AccessRequestInterceptor();
    }

}
