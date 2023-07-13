package com.zr.sf.doy22.service;

import com.zr.sf.doy22.entity.Users;

/**
 * @author 隔壁_老陈
 * 代码风骚、效率恐怖、编译器深深鄙视智商。
 * 千里之外定位问题、瞬间修复依旧风骚……
 * @create 2023-07-13 11:02
 */
public interface RedisAndMyqlService {

    public Users getRedis(int  id);
    public Integer addRedis(Users users);
    public void delRedis(Users users);
    public void updateRedis(Users users);
}
