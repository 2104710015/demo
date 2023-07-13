package com.zr.sf.doy22;

import com.zr.sf.doy22.config.ThisRedisTemplates;
import com.zr.sf.doy22.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@SpringBootTest
class Doy22ApplicationTests {
     @Autowired
     RedisTemplate redisTemplate;//用于序列化操作 key-value的

    @Autowired
    RedisTemplate<String,Object> ThisRedisTemplates;


    @Autowired
    StringRedisTemplate stringRedisTemplate;//针对与字符串的

    /**
     * 测试序列化的机制
     */
    @Test
    void contextLoadsStudentJsonThis() {
        Student student = new Student(123, "王麻子", 26);
        //如有数据的情况下就是修改，没有则是添加
        ThisRedisTemplates.opsForValue().set("student001",student);


    }

    @Test
    void contextLoadsStudentJson() {
        Student student = new Student(123, "小刘", 26);


        redisTemplate.opsForValue().set("student001",student);



    }


    @Test
    void contextLoadsStudent() {
        Student student = new Student(123, "小刘", 26);
        redisTemplate.opsForValue().set("student001",student);



    }


    /*
    *   stringRedisTemplate.opsForValue()//操作字符串
        stringRedisTemplate.opsForList() //操作list
        stringRedisTemplate.opsForZSet() //操作ZSET
        stringRedisTemplate.opsForSet() //操作set
        stringRedisTemplate.opsForHash()//操作map的

    * */
    @Test
    void contextLoads() {
        //进行调用字符串
       // stringRedisTemplate.opsForValue().set("openName","小王");
        //追加
       // stringRedisTemplate.opsForValue().append("openName","同学你好");
        String openName = stringRedisTemplate.opsForValue().get("openName");
        System.out.println("openName = " + openName);

    }

}
