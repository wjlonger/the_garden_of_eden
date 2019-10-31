package com.zqsy.onlinetool.vo;

import java.io.Serializable;

public class UploadFileInfoVo implements Serializable {

    private Integer id;

    private String originName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }
}