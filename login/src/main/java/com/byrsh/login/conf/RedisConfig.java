package com.byrsh.login.conf;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @Author: yangrusheng
 * @Description: Redis相关配置
 * @Date: Created in 16:18 2018/5/13
 * @Modified By:
 */
@Configuration
public class RedisConfig {

    @Value("${redis.host:127.0.0.1}")
    private String redisHost;
    @Value("${redis.port:6379}")
    private int redisPort;


    //配置连接工厂
    @Bean
    public RedisConnectionFactory redisCF(){
        JedisConnectionFactory factory = new JedisConnectionFactory();
        factory.setHostName(redisHost);
        factory.setPort(redisPort);
        factory.afterPropertiesSet();
        return factory;
    }

    //redisTemplate
    @Bean
    public RedisTemplate<String,Object> redisTemplate(@Qualifier("redisCF") RedisConnectionFactory jedisCF){
        RedisTemplate<String,Object> redis = new RedisTemplate<>();
        redis.setConnectionFactory(jedisCF);
        //设置key使用StringRedisSerializer序列化器，value使用Jackson2JsonRedisSerializer序列化器
        redis.setKeySerializer(new StringRedisSerializer());
        redis.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return redis;
    }

    //StringRedisTemplate
    @Bean
    public StringRedisTemplate stringRedisTemplate(@Qualifier("redisCF") RedisConnectionFactory jedisCF){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(jedisCF);
        //设置key使用StringRedisSerializer序列化器，value使用Jackson2JsonRedisSerializer序列化器
        stringRedisTemplate.setKeySerializer(new StringRedisSerializer());
        stringRedisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<Object>(Object.class));
        return stringRedisTemplate;
    }


}
