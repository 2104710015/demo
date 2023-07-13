package com.zr.sf.doy22.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiParam;

import java.util.Date;
import java.io.Serializable;

/**
 * (Users)实体类
 *
 * @author makejava
 * @since 2023-07-12 10:45:47
 */
public class Users implements Serializable {
    private static final long serialVersionUID = -10201716128004125L;

    private Integer id;
    
    private String name;
    
    private Integer age;
    
    private String adders;
    
    private String phone;
    
    private String love;
    
    private Date birth;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAdders() {
        return adders;
    }

    public void setAdders(String adders) {
        this.adders = adders;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

}

