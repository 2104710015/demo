package com.zr.sf.doy22.service;

import com.zr.sf.doy22.entity.Tom;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

/**
 * (Tom)表服务接口
 *
 * @author makejava
 * @since 2023-07-12 10:53:44
 */
public interface TomService {

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    Tom queryById(Integer tId);

    /**
     * 分页查询
     *
     * @param tom 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    Page<Tom> queryByPage(Tom tom, PageRequest pageRequest);

    /**
     * 新增数据
     *
     * @param tom 实例对象
     * @return 实例对象
     */
    Tom insert(Tom tom);

    /**
     * 修改数据
     *
     * @param tom 实例对象
     * @return 实例对象
     */
    Tom update(Tom tom);

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer tId);

}
