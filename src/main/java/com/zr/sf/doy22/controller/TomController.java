package com.zr.sf.doy22.controller;

import com.zr.sf.doy22.entity.Tom;
import com.zr.sf.doy22.service.TomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * (Tom)表控制层
 *
 * @author makejava
 * @since 2023-07-12 10:53:44
 */
@RestController
@RequestMapping("tom")
public class TomController {
    /**
     * 服务对象
     */
    @Autowired
    private TomService tomService;

    /**
     * 分页查询
     *
     * @param tom 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<Tom>> queryByPage(Tom tom, PageRequest pageRequest) {
        return ResponseEntity.ok(this.tomService.queryByPage(tom, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<Tom> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.tomService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param tom 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<Tom> add(Tom tom) {
        return ResponseEntity.ok(this.tomService.insert(tom));
    }

    /**
     * 编辑数据
     *
     * @param tom 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<Tom> edit(Tom tom) {
        return ResponseEntity.ok(this.tomService.update(tom));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.tomService.deleteById(id));
    }

}

