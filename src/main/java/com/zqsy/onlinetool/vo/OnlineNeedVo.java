package com.zqsy.onlinetool.vo;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

public class OnlineNeedVo implements Serializable {

    private Integer id;

    private String name;

    private Byte type;

    private Byte executePermission;

    private Integer appId;

    private List<OnlineNeedDetailVo> needs;

    private List<OnlineNeedRemarkVo> remarks;

    private List<OnlineNeedDetailVo> frontList;

    private List<OnlineNeedDetailVo> serverList;

    private List<OnlineNeedDetailVo> testList;

    private List<OnlineNeedRemarkVo> sqlList;

    private List<OnlineNeedRemarkVo> remarkList;

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

    public List<OnlineNeedDetailVo> getNeeds() {
        return needs;
    }

    public void setNeeds(List<OnlineNeedDetailVo> needs) {
        this.needs = needs;
    }

    public List<OnlineNeedRemarkVo> getRemarks() {
        return remarks;
    }

    public void setRemarks(List<OnlineNeedRemarkVo> remarks) {
        this.remarks = remarks;
    }

    public List<OnlineNeedDetailVo> getFrontList() {
        return this.needs.stream().filter(front -> front.getType().equals((byte) 0)).collect(Collectors.toList());
    }

    public List<OnlineNeedDetailVo> getServerList() {
        return this.needs.stream().filter(server -> server.getType().equals((byte) 1)).collect(Collectors.toList());
    }

    public List<OnlineNeedDetailVo> getTestList() {
        return this.needs.stream().filter(test -> test.getType().equals((byte) 2)).collect(Collectors.toList());
    }

    public List<OnlineNeedRemarkVo> getSqlList() {
        return this.remarks.stream().filter(sql -> sql.getType().equals((byte) 0)).collect(Collectors.toList());
    }

    public List<OnlineNeedRemarkVo> getRemarkList() {
        return this.remarks.stream().filter(remark -> remark.getType().equals((byte) 1)).collect(Collectors.toList());
    }

}