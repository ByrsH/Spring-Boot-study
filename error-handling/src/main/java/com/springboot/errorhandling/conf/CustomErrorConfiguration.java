package com.springboot.errorhandling.conf;

import com.springboot.errorhandling.controller.error.CustomizeErrorController;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.Servlet;
import java.util.List;

/**
 * @Author: yrs
 * @Description:
 * @Date: Greated in 15:40 2018/1/7
 * @Modified By:
 */
@Configuration
@ConditionalOnWebApplication
@ConditionalOnClass({Servlet.class, DispatcherServlet.class})
@AutoConfigureBefore({WebMvcAutoConfiguration.class})
@EnableConfigurationProperties({ResourceProperties.class})
public class CustomErrorConfiguration {
    private final ServerProperties serverProperties;
    private final List<ErrorViewResolver> errorViewResolvers;

    public CustomErrorConfiguration(ServerProperties serverProperties, ObjectProvider<List<ErrorViewResolver>> errorViewResolversProvider) {
        this.serverProperties = serverProperties;
        this.errorViewResolvers = (List)errorViewResolversProvider.getIfAvailable();
    }

    @Bean
    public CustomizeErrorController customizeErrorController(ErrorAttributes errorAttributes){
        return new CustomizeErrorController(errorAttributes, this.serverProperties.getError(),errorViewResolvers);
    }

}
