package com.zr.sf.doy22.service.impl;

import com.zr.sf.doy22.dao.UsersDao;
import com.zr.sf.doy22.entity.Users;
import com.zr.sf.doy22.service.RedisAndMyqlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 隔壁_老陈
 * 代码风骚、效率恐怖、编译器深深鄙视智商。
 * 千里之外定位问题、瞬间修复依旧风骚……
 * @create 2023-07-13 11:03
 */
@Service
public class RedisAndMyqlServiceImpl implements RedisAndMyqlService {
  public   static  final  String KEY_USER="users:";

    @Autowired
    private UsersDao  usersDao;

    @Autowired
    private RedisTemplate<String,Object> redisTemplate;

    /**
     * 处理数据击穿的逻辑问题
     *     在查询数据的时候
     *         避免击爆Mysql数据库 ,
     * @param id
     */
    @Override
    public Users getRedis(int id) {
        String  key =KEY_USER+id;
        Users users=null;
            //1.首先进行查询redis中的数据信息
        users= (Users) redisTemplate.opsForValue().get(key);
        if (users==null) {
            /**
             *2.防止数据击穿,使用双端检测机制
             *   对于高并发请求的情况下，使用锁
             *
             */
            ReentrantLock reentrantLock = new ReentrantLock();
            reentrantLock.lock();
            if (users==null) {
                users= usersDao.queryById(id);
                if (users==null) {
                    //2.1如果mysql数据中没有，那么直接返回null
                    return null;
                }else {
                    //2.2 如有数据进行写入到redis中
                    redisTemplate.opsForValue().set(key,users);
                    //扩展如存储数据有时间看控制的情况
                   // redisTemplate.opsForValue().setIfAbsent(key,users,1L, TimeUnit.HOURS);//存储有效的session
                }
            }
            reentrantLock.unlock();
        }
        return  users;
    }

    @Override
    public Integer addRedis(Users users) {
        //1.添加到mysql 数据库中g
        int insert = usersDao.insert(users);
        String  key =KEY_USER+users.getId();
        //2.成功进添加到redis中
        if (insert>0) {
            redisTemplate.opsForValue().set(key,users);
            //添加成功后，进行再次查询
            Users o = (Users) redisTemplate.opsForValue().get(key);
            if (o==null) {
                insert=0;
            }
        }
        return insert;
    }

    /**
     * //1.删除或者修改 到mysql 数据库中g
     *
     * //2.成功进删除或者修改到redis中
     *
     *
     * @param users
     */
    @Override
    public void delRedis(Users users) {
        String  key =KEY_USER+users.getId();
        int insert = usersDao.deleteById(users.getId());
        if (insert>0) {
            Boolean delete = redisTemplate.delete(key);
        }
    }

    @Override
    public void updateRedis(Users users) {
        String  key =KEY_USER+users.getId();
        int insert = usersDao.update(users);
        if (insert>0) {
            redisTemplate.opsForValue().set(key,users);
        }
    }
}
