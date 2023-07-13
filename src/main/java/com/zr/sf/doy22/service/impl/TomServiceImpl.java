package com.zr.sf.doy22.service.impl;

import com.zr.sf.doy22.dao.TomDao;
import com.zr.sf.doy22.entity.Tom;
import com.zr.sf.doy22.service.TomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import javax.annotation.Resource;

/**
 * (Tom)表服务实现类
 *
 * @author makejava
 * @since 2023-07-12 10:53:44
 */
@Service("tomService")
public class TomServiceImpl implements TomService {
    @Autowired
    private TomDao tomDao;

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    @Override
    public Tom queryById(Integer tId) {
        return this.tomDao.queryById(tId);
    }

    /**
     * 分页查询
     *
     * @param tom 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @Override
    public Page<Tom> queryByPage(Tom tom, PageRequest pageRequest) {
        long total = this.tomDao.count(tom);
        return new PageImpl<>(this.tomDao.queryAllByLimit(tom, pageRequest), pageRequest, total);
    }

    /**
     * 新增数据
     *
     * @param tom 实例对象
     * @return 实例对象
     */
    @Override
    public Tom insert(Tom tom) {
        this.tomDao.insert(tom);
        return tom;
    }

    /**
     * 修改数据
     *
     * @param tom 实例对象
     * @return 实例对象
     */
    @Override
    public Tom update(Tom tom) {
        this.tomDao.update(tom);
        return this.queryById(tom.getTId());
    }

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer tId) {
        return this.tomDao.deleteById(tId) > 0;
    }
}
