package com.zr.sf.doy22.service.impl;

import com.zr.sf.doy22.dto.UsersDto;
import com.zr.sf.doy22.entity.Users;
import com.zr.sf.doy22.dao.UsersDao;
import com.zr.sf.doy22.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * (Users)表服务实现类
 *
 * @author makejava
 * @since 2023-07-12 10:45:47
 */
@Service("usersService")
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersDao usersDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Users queryById(Integer id) {
        return this.usersDao.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Users> queryByPage(UsersDto users, PageRequest pageRequest) {

        /*
          编写对应业务逻辑进行封装对应的数据信息
          ‘
        *  就将对应的数据对象进行分离， 不会污染映射数据库中的实体对象
        * */
        Users users1 = new Users();
        users1.setId(users.getId());
        users1.setAdders(users.getAdders());

        long total = this.usersDao.count(users1);
        return new PageImpl<>(this.usersDao.queryAllByLimit(users1, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users insert(Users users) {
        this.usersDao.insert(users);
        return users;
    }

    /**
     * 修改数据
     *
     * @param users 实例对象
     * @return 实例对象
     */
    @Override
    public Users update(Users users) {
        this.usersDao.update(users);
        return this.queryById(users.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.usersDao.deleteById(id) > 0;
    }
}
