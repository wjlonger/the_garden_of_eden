package com.zqsy.onlinetool.vo;

import java.io.Serializable;

public class OnlineNeedRemarkVo implements Serializable {

    private Integer id;

    private Byte type;

    private Byte remarkType;

    private Integer needId;

    private String remark;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getRemarkType() {
        return remarkType;
    }

    public void setRemarkType(Byte remarkType) {
        this.remarkType = remarkType;
    }

    public Integer getNeedId() {
        return needId;
    }

    public void setNeedId(Integer needId) {
        this.needId = needId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}