package com.zqsy.onlinetool.vo;

import java.io.Serializable;

public class OnlineFinishVo implements Serializable {

    private Integer id;

    private String onlineVersion;

    private String onlineAppName;

    private Integer appId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOnlineVersion() {
        return onlineVersion;
    }

    public void setOnlineVersion(String onlineVersion) {
        this.onlineVersion = onlineVersion == null ? null : onlineVersion.trim();
    }

    public String getOnlineAppName() {
        return onlineAppName;
    }

    public void setOnlineAppName(String onlineAppName) {
        this.onlineAppName = onlineAppName == null ? null : onlineAppName.trim();
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }
}
