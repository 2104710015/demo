package com.zr.sf.doy22.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;
import lombok.*;

import java.io.Serializable;
import java.util.Date;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2023-07-12 10:45:47
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@ApiModel("用户实体类")
public class UsersDto implements Serializable {

    @ApiParam("用户编号")
    private Integer id;
    @ApiParam("用户名称")
    private Integer age;
    @ApiParam("用户地址")
    private String adders;
    @ApiParam("用户手机号")
    private String phone;


}

