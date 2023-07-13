package com.zr.sf.doy22.dao;

import com.zr.sf.doy22.entity.Tom;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Pageable;
import java.util.List;

/**
 * (Tom)表数据库访问层
 *
 * @author makejava
 * @since 2023-07-12 10:53:44
 */
@Mapper
public interface TomDao {

    /**
     * 通过ID查询单条数据
     *
     * @param tId 主键
     * @return 实例对象
     */
    Tom queryById(Integer tId);

    /**
     * 查询指定行数据
     *
     * @param tom 查询条件
     * @param pageable         分页对象
     * @return 对象列表
     */
    List<Tom> queryAllByLimit(Tom tom, @Param("pageable") Pageable pageable);

    /**
     * 统计总行数
     *
     * @param tom 查询条件
     * @return 总行数
     */
    long count(Tom tom);

    /**
     * 新增数据
     *
     * @param tom 实例对象
     * @return 影响行数
     */
    int insert(Tom tom);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Tom> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Tom> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Tom> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<Tom> entities);

    /**
     * 修改数据
     *
     * @param tom 实例对象
     * @return 影响行数
     */
    int update(Tom tom);

    /**
     * 通过主键删除数据
     *
     * @param tId 主键
     * @return 影响行数
     */
    int deleteById(Integer tId);

}

