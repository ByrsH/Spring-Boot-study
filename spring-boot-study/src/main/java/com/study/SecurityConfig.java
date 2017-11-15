package com.study;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 简单的安全性配置
 *
 * @author ByrsH
 * @create 2017-09-05 21:02
 **/

public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception{
        http
                .authorizeRequests().anyRequest().permitAll()
                .and()
                .csrf();
    }
}
