package com.zr.sf.doy22.config;

import com.fasterxml.jackson.databind.util.ObjectBuffer;
import com.zr.sf.doy22.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

/**
 * @author 隔壁_老陈
 * 代码风骚、效率恐怖、编译器深深鄙视智商。
 * 千里之外定位问题、瞬间修复依旧风骚……
 * @create 2023-07-13 10:01
 */

@Configuration
public class ThisRedisTemplates {

    /**
     *  自定义的student的序列化机制
     * @param redisConnectionFactory
     * @return
     */
  //  @Bean
    public  RedisTemplate<Object, Student> getRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        RedisTemplate<Object, Student> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);

        Jackson2JsonRedisSerializer<Student> studentJackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Student.class);
        objectObjectRedisTemplate.setDefaultSerializer(studentJackson2JsonRedisSerializer);
        return  objectObjectRedisTemplate;
    }


    @Autowired
    private  RedisConnectionFactory redisConnectionFactory;

    @Bean
    public  RedisTemplate<String,Object> thisRedisTemplate(){
        RedisTemplate<String, Object> objectObjectRedisTemplate = new RedisTemplate<>();
        objectObjectRedisTemplate.setConnectionFactory(redisConnectionFactory);
        objectObjectRedisTemplate.setKeySerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.setValueSerializer(new GenericJackson2JsonRedisSerializer());
        objectObjectRedisTemplate.setHashKeySerializer(new StringRedisSerializer());
        objectObjectRedisTemplate.afterPropertiesSet();
        return  objectObjectRedisTemplate;
    }





}
