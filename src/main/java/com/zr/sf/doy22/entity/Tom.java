package com.zr.sf.doy22.entity;

import java.io.Serializable;

/**
 * (Tom)实体类
 *
 * @author makejava
 * @since 2023-07-12 10:53:44
 */
public class Tom implements Serializable {
    private static final long serialVersionUID = -71787467163218878L;
    
    private Integer tId;
    
    private String tName;
    
    private String tColor;
    
    private Integer tUId;


    public Integer getTId() {
        return tId;
    }

    public void setTId(Integer tId) {
        this.tId = tId;
    }

    public String getTName() {
        return tName;
    }

    public void setTName(String tName) {
        this.tName = tName;
    }

    public String getTColor() {
        return tColor;
    }

    public void setTColor(String tColor) {
        this.tColor = tColor;
    }

    public Integer getTUId() {
        return tUId;
    }

    public void setTUId(Integer tUId) {
        this.tUId = tUId;
    }

}

