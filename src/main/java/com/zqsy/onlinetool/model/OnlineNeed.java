package com.zqsy.onlinetool.model;

import java.io.Serializable;

public class OnlineNeed implements Serializable {

    private Integer id;

    private String name;

    private Byte type;

    private Byte executePermission;

    private Integer appId;

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
        this.name = name == null ? null : name.trim();
    }

    public Byte getType() {
        return type;
    }

    public void setType(Byte type) {
        this.type = type;
    }

    public Byte getExecutePermission() {
        return executePermission;
    }

    public void setExecutePermission(Byte executePermission) {
        this.executePermission = executePermission;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }
}