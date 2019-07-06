package com.work.framework.biz.config;

import com.work.framework.biz.common.interceptor.MyHandlerInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableTransactionManagement
public class MyConfig extends WebMvcConfigurerAdapter {

    @Bean
    public MyHandlerInterceptor myHandlerInterceptor(){
        return new MyHandlerInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(myHandlerInterceptor());
    }

    @Bean
    public RedisTemplate<Object,Object> redisTemplate(RedisConnectionFactory factory) {
        RedisTemplate<Object,Object> template=new RedisTemplate<Object, Object>();
        template.setConnectionFactory(factory);
        return template;
    }
}
