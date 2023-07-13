package com.zr.sf.doy22.controller;

import com.zr.sf.doy22.dto.UsersDto;
import com.zr.sf.doy22.entity.Users;
import com.zr.sf.doy22.service.RedisAndMyqlService;
import com.zr.sf.doy22.service.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2023-07-12 10:45:47
 */
@RestController
@RequestMapping("users")
@Api(value = "Users测试API接口")
public class UsersController {
    /**
     * 服务对象
     */
    @Autowired
    private UsersService usersService;
    @Autowired
    private RedisAndMyqlService redisAndMyqlService;

    /**
     * 分页查询
     *
     * @param users 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @ApiOperation(value = "分页查询")
    @GetMapping("/queryByPage")
    public ResponseEntity<Page<Users>> queryByPage(UsersDto users) {
        PageRequest of = PageRequest.of(1, 20);
        return ResponseEntity.ok(this.usersService.queryByPage(users, of));
    }


    @ApiOperation(value = "查询单个，测试防止数据击穿")
    @GetMapping("/queryRedisById/{id}")
    public ResponseEntity<Users> queryRedisById(@ApiParam("查询用户的id编号") @PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.redisAndMyqlService.getRedis(id));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "查询单个")
    @GetMapping("{id}")
    public ResponseEntity<Users> queryById(@ApiParam("查询用户的id编号") @PathVariable("id") Integer id) {



        return ResponseEntity.ok(this.usersService.queryById(id));
    }
    @ApiOperation(value = "通过id查询单个")
    @GetMapping("/queryByName/{id}")
    public ResponseEntity<Users> queryByName(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.usersService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param users 实体
     * @return 新增结果
     */
    @ApiOperation(value = "新增数据")
    @PostMapping
    public ResponseEntity<Users> add(Users users) {
        return ResponseEntity.ok(this.usersService.insert(users));
    }

    /**
     * 编辑数据
     *
     * @param users 实体
     * @return 编辑结果
     */
    @ApiOperation(value = "编辑数据")
    @PutMapping
    public ResponseEntity<Users> edit(Users users) {
        return ResponseEntity.ok(this.usersService.update(users));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @ApiOperation(value = "删除数据")
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.usersService.deleteById(id));
    }

}

