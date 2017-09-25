package com.study;

import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * Spring Session redis 配置
 *
 * @author ByrsH
 * @create 2017-09-25 22:55
 **/
@EnableRedisHttpSession
public class HttpSessionConfig {
    @Bean
    public RedisConnectionFactory connectionFactory(){
        JedisConnectionFactory connectionFactory = new JedisConnectionFactory();
        connectionFactory.setPort(6379);
        connectionFactory.setHostName("localhost");
        return connectionFactory;
    }
}
