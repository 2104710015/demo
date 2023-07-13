package com.zr.sf.doy22.redis;

import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * @author 隔壁_老陈
 * 代码风骚、效率恐怖、编译器深深鄙视智商。
 * 千里之外定位问题、瞬间修复依旧风骚……
 * @create 2023-07-12 16:21
 */
public class TestRedis {
    public static void main(String[] args) {
        /**
         * 测试java代码连接redis
         */
        Jedis jedis = new Jedis("127.0.0.1", 6379);

            //存储字符串
        String set = jedis.set("name", "小王");
        System.out.println("set = " + set);
        String name = jedis.get("name");
        System.out.println("name = " + name);

        /**
         * redis常用的数据类型
         *    string  字符串
         *    map
         *    set
         *    list
         *    sortdset=>zet
         */
        /**
         * 连接池
         */
        JedisPool jedisPool = new JedisPool("127.0.0.1",6379);
         jedisPool.setMaxIdle(30);  //最大最小的空闲时间
         jedisPool.setMinIdle(10);
              //最大的连接数
         jedisPool.setMaxTotal(35);


        Jedis resource = jedisPool.getResource();
        String name1 = resource.get("name");
        System.out.println("name1 = " + name1);


    }
}
